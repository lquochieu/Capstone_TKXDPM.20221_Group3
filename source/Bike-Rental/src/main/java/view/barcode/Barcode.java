package view.barcode;

import controller.barcode.BarcodeController;
import controller.bike.RentingBikeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.entity.bike.BikeView;
import utils.Config;
import view.BaseScreen;
import view.bike.BikeDetailScreen;

import java.io.IOException;

/**
 * view barcode form
 *
 * @author Group 3
 */
public class Barcode extends BaseScreen {

    @FXML
    private TextField barcode;

    public Barcode(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public BarcodeController getBController() {
        return (BarcodeController) super.getBController();
    }

    public void confirm(ActionEvent actionEvent) throws Exception {
        BikeView bike = getBController().processBarcode(barcode.getText());
        BikeDetailScreen bikeDetailScreen = new BikeDetailScreen(this.stage, Config.BIKE_DETAIL_SCREEN_PATH);
        bikeDetailScreen.setBController(new RentingBikeController());
        bikeDetailScreen.setPreviousScreen(this);
        bikeDetailScreen.Initialize(bike);
        bikeDetailScreen.display();
    }

    public void back(ActionEvent actionEvent) {
        this.stage.close();
    }
}
