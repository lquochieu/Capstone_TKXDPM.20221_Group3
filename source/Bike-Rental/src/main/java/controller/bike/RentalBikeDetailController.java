package controller.bike;

import controller.BaseController;
import controller.calculateMoney.Calculator;
import controller.calculateMoney.ICalculatorStrategy;
import model.dao.DockDAO;
import model.dao.bike.BikeDaoFactory;
import model.entity.bike.Bike;
import model.entity.bike.BikeView;
import model.entity.dock.Dock;
import model.entity.transaction.Transaction;

import java.util.List;

/**
 * @author Group 3
 */
 
public class RentalBikeDetailController extends BaseController {

    DockDAO dockDAO = new DockDAO();
    BikeDaoFactory bikeDaoFactory = new BikeDaoFactory();
    private Transaction transaction;

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public BikeView getRentalBike() {
        return bikeDaoFactory.bikeDAOByID(transaction.getBikeId()).getByID(transaction.getBikeId());
    }

    public Dock getDock(Bike bike) {
        return dockDAO.getByID(bike.getDockId());
    }

    public List<Dock> getDockList() {
        return dockDAO.getAll();
    }

    public int getRentalAmount() {
        ICalculatorStrategy calculator = new Calculator();
        return calculator.getTotal(transaction.getRentalTime());
    }
}
