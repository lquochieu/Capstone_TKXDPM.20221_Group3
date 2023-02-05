package view.dock;

import controller.barcode.BarcodeController;
import controller.dock.DockDetailController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import model.dao.bike.BikeDaoFactory;
import model.entity.bike.BikeView;
import model.entity.dock.Dock;
import utils.Config;
import view.BaseScreen;
import view.barcode.Barcode;
import view.bike.BikeItem;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * view dock detail 
 *
 * @author Group 3
 */
public class DockDetailScreen extends BaseScreen implements Initializable {

    @FXML
    private Label dockName;
    @FXML
    private Label address;
    @FXML
    private Label numBike;
    @FXML
    private Label bikeType;
    @FXML
    private Label numSpecBike;
    @FXML
    private Label area;
    @FXML
    private Label status;
    @FXML
    private VBox bikeList;
    @FXML
    private HBox sideBar;

    private Dock dock;

    private BikeDaoFactory.BikeType currentBikeType;

    public DockDetailScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public DockDetailController getBController() {
        return (DockDetailController) super.getBController();
    }

    @SneakyThrows
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentBikeType = BikeDaoFactory.BikeType.BICYCLE;
        ToggleGroup toggleGroup = new ToggleGroup();
        for (BikeDaoFactory.BikeType bikeType : BikeDaoFactory.BikeType.values()) {
            ToggleButton toggle = new ToggleButton();
            toggle.setText(bikeType.toString());
            toggle.getStyleClass().add("side-toggle");
            toggle.setOnAction(actionEvent -> {
                currentBikeType = bikeType;
                toggle.setSelected(true);
                try {
                    getBikeList(actionEvent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            sideBar.getChildren().add(toggle);
            toggle.setToggleGroup(toggleGroup);
        }
        toggleGroup.getToggles().get(0).setSelected(true);
    }

    @SneakyThrows
    public void Initialize(Dock dock) {
        this.dock = dock;
        dockName.setText(dock.getName());
        address.setText(dock.getAddress());
        area.setText(dock.getArea() + " m2");
        status.setText(String.valueOf(dock.getStatusString()));
        setBikeItem();
    }

    private void setBikeItem() throws IOException {
        bikeType.setText(currentBikeType.toString() + ":");
        numSpecBike.setText(String.valueOf(getBController().getNumSpecBike(dock.getId(), currentBikeType.getInt())));
        List<BikeView> listBike = getBController().getAllBike(dock.getId(), currentBikeType.getInt());
        for (BikeView bike : listBike) {
            BikeItem bikeItem = new BikeItem(Config.BIKE_ITEM_PATH);
            bikeItem.setBaseScreen(this);
            bikeItem.setBaseController(getBController());
            bikeItem.Initialize(bike);
            bikeList.getChildren().add(bikeItem.getContent());
        }
    }

    public void setNumBike(String numBike) {
        this.numBike.setText(numBike);
    }

    public void rentBike(ActionEvent actionEvent) throws IOException {
        Barcode barcode = new Barcode(new Stage(), Config.BARCODE_PATH);
        barcode.setBController(new BarcodeController());
        barcode.getStage().initModality(Modality.APPLICATION_MODAL);
        barcode.display();
    }

    public void getBikeList(ActionEvent actionEvent) throws IOException {
        bikeList.getChildren().clear();
        setBikeItem();
    }

    public void back(ActionEvent actionEvent) {
        getPreviousScreen().display();
    }
}