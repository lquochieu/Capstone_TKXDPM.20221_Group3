package controller.bike;

import controller.BaseController;
import controller.calculateMoney.Calculator;
import model.dao.*;
import model.dao.bike.BikeDAO;
import model.dao.bike.BikeDaoFactory;
import model.entity.bike.Bike;
import model.entity.card.Card;
import model.entity.dock.Dock;
import model.entity.invoice.Invoice;
import model.entity.invoice.InvoiceView;
import model.entity.transaction.PaymentTransaction;
import model.entity.transaction.Transaction;
import model.entity.user.User;
import subsystem.banksubsystem.InterbankInterface;
import subsystem.banksubsystem.InterbankSubsystem;
import utils.Config;

/**
 * @author Group 3
 */
 
public class ReturnBikeController extends BaseController {

    DockDAO dockDAO = new DockDAO();
    CardDAO cardDao = new CardDAO();
    PaymentTransactionDAO ptDao = new PaymentTransactionDAO();
    InvoiceDAO invoiceDAO = new InvoiceDAO();

    TransactionDAO transactionDAO = new TransactionDAO();
    BikeDaoFactory bikeDaoFactory = new BikeDaoFactory();
    InterbankInterface interbankSubsystem = new InterbankSubsystem();

    public InvoiceView processReturnBike(Dock dock) {
        Transaction transaction = transactionDAO.getTransactionByUserID(User.getInstance().getId());
        BikeDAO bikeDAO = bikeDaoFactory.bikeDAOByID(transaction.getBikeId());
        Bike bike = bikeDAO.getByID(transaction.getBikeId()).getBike();
        Dock rentalDock = dockDAO.getByID(bike.getDockId());
        int time = transaction.getRentalTime();
        int fees = calculateRentalFees(transaction);
        int refund = bike.getDeposit() - fees;
        Card card = cardDao.getByTransactionID(transaction.getId());
        PaymentTransaction paymentTransaction;
        if (refund >= 0) {
            paymentTransaction = interbankSubsystem.refund(card, refund, "Rental bike refund");
        } else {
            paymentTransaction = interbankSubsystem.pay(card, - refund, "Extra rental bike");
        }
        if (paymentTransaction.getErrorCode() == Config.noErrorCode) {
            bikeDAO.updateReturnBike(bike.getId(), dock.getId());
            paymentTransaction.setTransactionId(transaction.getId());
            int paymentTransactionID = ptDao.save(paymentTransaction);
            transaction.setTotalTime(time);
            transactionDAO.updateStatus(transaction.getId(), time);
            Invoice invoice = new Invoice(paymentTransactionID, dock.getId());
            invoiceDAO.save(invoice);
            return new InvoiceView(User.getInstance().getName(), card.getId(), card.getDateExpire(),
                    bike.getTypeString(), rentalDock.getName(), dock.getName(), time, fees, bike.getDeposit(), refund);
        }
        return null;
    }

    public int getNumBlank(Dock dock) {
        return dock.getBikeAmount() - dockDAO.getNumBike(dock.getId());
    }

    public int calculateRentalFees(Transaction transaction) {
        return new Calculator().getTotal(transaction.getRentalTime());
    }
}
