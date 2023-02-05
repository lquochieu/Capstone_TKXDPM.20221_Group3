package view.dock;

import controller.dock.DockListController;
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
 * view list dock
 *
 * @author Group 3
 */
public class DockListScreen extends BaseScreen {
    @FXML
    public VBox dockList;

    public DockListScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public DockListController getBController() {
        return (DockListController) super.getBController();
    }

    public void Initialize(List<Dock> listDock) throws IOException {
        for (int i = 0; i < listDock.size(); i++) {
            DockItem dockItem = new DockItem(Config.DOCK_ITEM_PATH);
            dockItem.setBaseScreen(this);
            dockItem.setBaseController(getBController());
            dockItem.Initialize(listDock.get(i));
            dockList.getChildren().add(dockItem.getContent());
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        getPreviousScreen().display();
    }
}
