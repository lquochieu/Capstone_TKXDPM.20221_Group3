package controller.bike;

import controller.BaseController;
import javafx.stage.Stage;
import model.dao.DockDAO;
import model.entity.bike.Bike;
import model.entity.dock.Dock;
import model.entity.transaction.Transaction;
import model.entity.user.User;

/**
 * @author Group 3
 */
public class RentingBikeController extends BaseController {
    Transaction transaction;
    DockDAO dockDAO = new DockDAO();
    private Stage stage;

    public Dock getDock(Bike bike) {
        return dockDAO.getByID(bike.getDockId());
    }

    public Transaction confirmToRent(Bike bike) throws Exception {
        transaction = new Transaction(User.getInstance().getId(), bike.getId());
        return transaction;
    }
}

