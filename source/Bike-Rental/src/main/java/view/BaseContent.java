package view;

import controller.BaseController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * @author Group 3
 */
public class BaseContent extends FXMLScreen {
    private BaseScreen baseScreen;
    private BaseController baseController;

    public BaseContent(String contentPath) throws IOException {
        super(contentPath);
        this.loader = new FXMLLoader(getClass().getResource(contentPath));
        // Set this class as the controller
        this.loader.setController(this);
        this.content = loader.load();
    }

    public BaseScreen getBaseScreen() {
        return this.baseScreen;
    }

    public void setBaseScreen(BaseScreen baseScreen) {
        this.baseScreen = baseScreen;
    }

    public BaseController getBaseController() {
        return this.baseController;
    }

    public void setBaseController(BaseController baseController) {
        this.baseController = baseController;
    }
}
