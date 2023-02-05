package view.home;

import controller.HomeController;
import controller.bike.RentalBikeDetailController;
import controller.dock.DockListController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.entity.dock.Dock;
import model.entity.transaction.Transaction;
import utils.Config;
import utils.Message;
import view.BaseScreen;
import view.bike.RentalBikeDetailScreen;
import view.dock.DockListScreen;

import java.io.IOException;
import java.util.List;

/**
 * view home RentalBike
 *
 * @author Group 3
 */
public class HomeScreen extends BaseScreen {

    public HomeScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public HomeController getBController() {
        return (HomeController) super.getBController();
    }

    public void viewDockList(ActionEvent actionEvent) throws IOException {
        Transaction transaction = getBController().getTransaction();
        if (transaction != null && transaction.getStatus() == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, Message.NOT_RETURN_BIKE_YET);
            alert.show();
        } else {
            List<Dock> dockList = getBController().GetDockList();
            DockListScreen dockListScreen = new DockListScreen(this.stage, Config.DOCK_LIST_SCREEN_PATH);
            dockListScreen.setPreviousScreen(this);
            dockListScreen.setBController(new DockListController());
            dockListScreen.Initialize(dockList);
            dockListScreen.display();
        }
    }

    public void viewRentalBikeDetail(ActionEvent actionEvent) throws IOException {
        Transaction transaction = getBController().getTransaction();
        if (transaction == null || transaction.getStatus() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, Message.NOT_RENTED_BIKE_YET);
            alert.show();
        } else {
            RentalBikeDetailScreen screen = new RentalBikeDetailScreen(this.stage, Config.RENTAL_BIKE_DETAIL_SCREEN_PATH);
            screen.setPreviousScreen(this);
            RentalBikeDetailController controller = new RentalBikeDetailController();
            screen.setBController(controller);
            controller.setTransaction(transaction);
            screen.Initialize(transaction, controller.getRentalBike());
            screen.display();
        }
    }
}