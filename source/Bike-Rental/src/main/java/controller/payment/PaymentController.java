package controller.payment;

import controller.BaseController;
import model.dao.PaymentTransactionDAO;
import model.dao.TransactionDAO;
import model.dao.bike.BikeDaoFactory;
import model.entity.card.Card;
import model.entity.card.CreditCard;
import model.entity.transaction.PaymentTransaction;
import model.entity.transaction.Transaction;
import model.entity.user.User;
import subsystem.banksubsystem.InterbankSubsystem;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class PaymentController extends BaseController {
    private InterbankSubsystem interbankSubsystem;
    private Card card;

    private BikeDaoFactory bikeDaoFactory = new BikeDaoFactory();

    public PaymentController() {
        this.interbankSubsystem = new InterbankSubsystem();
    }

    public PaymentTransaction deposit(String id, String issuingBank, String owner, String cvv, LocalDate dateExpired, int amount, String content) {
        card = new CreditCard(id, User.getInstance().getId(), issuingBank, owner, cvv, dateExpired);
        return interbankSubsystem.pay(card, amount, content);
    }

    public int savePaymentTransaction(PaymentTransaction paymentTransaction) {
        int id = -1;
        try {
            PaymentTransactionDAO paymentTransactionDao = new PaymentTransactionDAO();
            id = paymentTransactionDao.save(paymentTransaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public int saveTransaction(Transaction transaction) {
        int id = -1;
        try {
            bikeDaoFactory.bikeDAOByID(transaction.getBikeId()).updateStatus(transaction.getBikeId(), 0);

            TransactionDAO transactionDAO = new TransactionDAO();
            transaction.setStatus(1);
            transaction.setDateTime(LocalDateTime.now());

            id = transactionDAO.save(transaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }


}
