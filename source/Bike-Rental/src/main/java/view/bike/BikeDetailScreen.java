package view.bike;

import controller.bike.RentingBikeController;
import controller.payment.PaymentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.entity.bike.BikeView;
import model.entity.dock.Dock;
import utils.Config;
import utils.Message;
import view.BaseScreen;
import view.payment.PaymentMethod;

import java.io.IOException;

/**
 * view bike detail
 *
 * @author Group 3
 */
public class BikeDetailScreen extends BaseScreen {

    @FXML
    private Label bikeName;
    @FXML
    private Label bikeID;
    @FXML
    private Label licensePlate;
    @FXML
    private Label bikeType;
    @FXML
    private Label battery;
    @FXML
    private Label barcode;
    @FXML
    private Label value;
    @FXML
    private Label depositValue;
    @FXML
    private Label notification;
    @FXML
    private Button rentButton;
    @FXML
    private AnchorPane batteryPane;
    @FXML
    private AnchorPane licensePlatePane;
    @FXML
    private Label dockName;
    @FXML
    private Label address;

    private BikeView bike;

    public BikeDetailScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public RentingBikeController getBController() {
        return (RentingBikeController) super.getBController();
    }

    public void Initialize(BikeView bikeView) throws IOException {
        this.bikeName.setText(bikeView.getBike().getTypeString() + " " + bikeView.getBike().getId());
        this.bikeID.setText(String.valueOf(bikeView.getBike().getId()));
        this.bikeType.setText(String.valueOf(bikeView.getBike().getTypeString()));
        this.barcode.setText(bikeView.getBike().getBarcode());
        this.value.setText(String.valueOf(bikeView.getBike().getValue()));
        this.depositValue.setText(String.valueOf(bikeView.getBike().getDeposit()));
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

        if (!bikeView.getBike().isStatus() || !dock.isStatus()) {
            this.notification.setText(Message.UNAVAILABLE_TO_RENT);
            this.rentButton.setDisable(true);
        } else {
            notification.setText(Message.AVAILABLE_TO_RENT);
            this.rentButton.setDisable(false);
        }
        this.bike = bikeView;
    }

    public void confirmToRent(ActionEvent actionEvent) throws Exception {
        PaymentMethod paymentMethod = new PaymentMethod(stage, Config.PAYMENT_METHOD_PATH);
        paymentMethod.setBController(new PaymentController());
        paymentMethod.setPreviousScreen(this);
        paymentMethod.Initialize(getBController().confirmToRent(bike.getBike()), bike.getBike().getDeposit());
        paymentMethod.display();
    }

    public void back(ActionEvent actionEvent) {
        this.stage.close();
    }
}