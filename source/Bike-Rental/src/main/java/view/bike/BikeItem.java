package view.bike;

import controller.bike.RentingBikeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entity.bike.BikeView;
import utils.Config;
import view.BaseContent;

import java.io.IOException;

/**
 * view each bike in list bikes
 *
 * @author Group 3
 */
public class BikeItem extends BaseContent {

    @FXML
    private Label bikeName;
    @FXML
    private Label bikeType;
    @FXML
    private Label value;
    @FXML
    private Label battery;
    @FXML
    private AnchorPane batteryPane;
    @FXML
    private Button button;

    private BikeView bike;

    public BikeItem(String contentPath) throws IOException {
        super(contentPath);
    }

    public void Initialize(BikeView bikeView) {
        this.bike = bikeView;
        bikeType.setText(bikeView.getBike().getTypeString());
        bikeName.setText(bikeType.getText() + " " + bikeView.getBike().getId());
        value.setText(String.valueOf(bikeView.getBike().getValue()));
        if (bikeView.getBattery() != null) {
            battery.setText(String.valueOf(bikeView.getBattery()) + "%");
        } else {
            removeChild(batteryPane);
        }
    }

    public void viewBikeDetail(ActionEvent actionEvent) throws IOException {
        BikeDetailScreen bikeDetailScreen = new BikeDetailScreen(new Stage(), Config.BIKE_DETAIL_SCREEN_PATH);
        bikeDetailScreen.setBController(new RentingBikeController());
        bikeDetailScreen.Initialize(bike);
        bikeDetailScreen.getStage().initModality(Modality.APPLICATION_MODAL);
        bikeDetailScreen.setPreviousScreen(getBaseScreen());
        bikeDetailScreen.display();
    }

}
