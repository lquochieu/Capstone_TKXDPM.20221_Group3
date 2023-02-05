package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * @author Group 3
 */
public class FXMLScreen {

    protected FXMLLoader loader;
    protected Parent content;

    public FXMLScreen(String screenPath) throws IOException {
        this.loader = new FXMLLoader(getClass().getResource(screenPath));
        // Set this class as the controller
        this.loader.setController(this);
        this.content = loader.load();
    }

    public Parent getContent() {
        return this.content;
    }

    public FXMLLoader getLoader() {
        return this.loader;
    }

    public void removeChild(Node node) {
        ((Pane) node.getParent()).getChildren().remove(node);
    }
}