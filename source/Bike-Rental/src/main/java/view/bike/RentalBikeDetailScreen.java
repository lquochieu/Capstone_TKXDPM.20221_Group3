package view.bike;


import controller.bike.RentalBikeDetailController;
import controller.bike.ReturnBikeController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.entity.bike.Bike;
import model.entity.bike.BikeView;
import model.entity.dock.Dock;
import model.entity.transaction.Transaction;
import utils.Config;
import utils.Utils;
import view.BaseScreen;
import view.dock.DockReturnScreen;

import java.io.IOException;
import java.util.List;

/**
 * view bike in use
 *
 * @author Group 3
 */
public class RentalBikeDetailScreen extends BaseScreen {

    @FXML
    private Label bikeID;
    @FXML
    private Label bikeName;
    @FXML
    private Label bikeType;
    @FXML
    private Label licensePlate;
    @FXML
    private Label battery;
    @FXML
    private Label rentalTime;
    @FXML
    private Label amount;
    @FXML
    private AnchorPane licensePlatePane;
    @FXML
    private AnchorPane batteryPane;
    @FXML
    private Label dockName;
    @FXML
    private Label address;

    public RentalBikeDetailScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    @Override
    public RentalBikeDetailController getBController() {
        return (RentalBikeDetailController) super.getBController();
    }

    public void Initialize(Transaction transaction, BikeView bikeView) {
        Bike bike = bikeView.getBike();
        bikeID.setText(String.valueOf(bike.getId()));
        bikeName.setText(bike.getTypeString() + " " + bike.getId());
        bikeType.setText(bike.getTypeString());

        if (bikeView.getBattery() != null) {
            battery.setText(bikeView.getBattery() + "%");
        } else {
            removeChild(batteryPane);
        }

        if (bikeView.getLicensePlate() != null) {
            licensePlate.setText(bikeView.getLicensePlate());
        } else {
            removeChild(licensePlatePane);
        }

        Dock dock = getBController().getDock(bikeView.getBike());
        dockName.setText(dock.getName());
        address.setText(dock.getAddress());
        rentalTime.setText("");
        amount.setText("");
        Timeline timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), actionEvent -> {
            int time = transaction.getRentalTime();
            rentalTime.setText(Utils.formatTime(time));
            time++;
            amount.setText(String.valueOf(getBController().getRentalAmount()));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void returnBike(ActionEvent actionEvent) throws Exception {
        List<Dock> dockList = getBController().getDockList();
        DockReturnScreen dockReturnScreen = new DockReturnScreen(this.stage, Config.DOCK_RETURN_SCREEN_PATH);
        dockReturnScreen.setBController(new ReturnBikeController());
        dockReturnScreen.setPreviousScreen(this);
        dockReturnScreen.Initialize(getBController().getDockList());
        dockReturnScreen.display();
    }

    public void back(ActionEvent actionEvent) {
        getPreviousScreen().display();
    }
}
