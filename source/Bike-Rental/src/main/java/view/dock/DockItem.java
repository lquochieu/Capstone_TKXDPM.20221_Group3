package view.dock;

import controller.dock.DockDetailController;
import controller.dock.DockListController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.entity.dock.Dock;
import utils.Config;
import view.BaseContent;

import java.io.IOException;

/**
 * view each dock in list docks
 *
 * @author Group 3
 */
public class DockItem extends BaseContent {
    @FXML
    private Label name;
    @FXML
    private Label address;
    @FXML
    private Label numBike;
    @FXML
    private Label status;
    @FXML
    private Label distance;
    @FXML
    private Button viewDockButton;

    private Dock dock;

    public DockItem(String screenPath) throws IOException {
        super(screenPath);
    }

    public DockListController getBaseController() {
        return (DockListController) super.getBaseController();
    }

    public void Initialize(Dock dock) {
        this.dock = dock;
        name.setText(dock.getName());
        address.setText(dock.getAddress());
        status.setText(dock.getStatusString());
        distance.setText("100m");
        numBike.setText(String.valueOf(getBaseController().getNumBike(dock.getId())));
    }

    public void viewDockDetail(ActionEvent actionEvent) throws IOException {
        DockDetailScreen dockDetailScreen = new DockDetailScreen(getBaseScreen().getStage(), Config.DOCK_DETAIL_SCREEN_PATH);
        dockDetailScreen.setNumBike(numBike.getText());
        dockDetailScreen.setBController(new DockDetailController());
        dockDetailScreen.Initialize(dock);
        dockDetailScreen.setPreviousScreen(getBaseScreen());
        dockDetailScreen.display();
    }
}
