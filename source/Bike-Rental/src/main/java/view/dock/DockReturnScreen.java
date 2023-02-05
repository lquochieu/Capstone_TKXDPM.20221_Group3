package view.dock;

import controller.bike.ReturnBikeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.entity.dock.Dock;
import utils.Config;
import view.BaseScreen;

import java.io.IOException;
import java.util.List;

/**
 * view list docks when return bike
 *
 * @author Group 3
 */
public class DockReturnScreen extends BaseScreen {

    @FXML
    private VBox dockList;

    public DockReturnScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public ReturnBikeController getBController() {
        return (ReturnBikeController) super.getBController();
    }

    public void Initialize(List<Dock> listDock) throws IOException {
        for (Dock dock : listDock) {
            DockReturnItem dockReturnItem = new DockReturnItem(Config.DOCK_RETURN_ITEM_PATH);
            dockReturnItem.setBaseController(getBController());
            dockReturnItem.setBaseScreen(this);
            dockReturnItem.Initialize(dock);
            dockList.getChildren().add(dockReturnItem.getContent());
        }
    }

    public void back(ActionEvent actionEvent) {
        getPreviousScreen().display();
    }
}
