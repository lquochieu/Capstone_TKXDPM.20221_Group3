package view.home;

import controller.HomeController;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.Config;
import view.BaseScreen;
import view.FXMLScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Group 3
 */
public class SplashScreen extends BaseScreen {

    @FXML
    private AnchorPane logo;

    private final EventHandler<MouseEvent> eventEventHandler = mouseEvent -> openHomeScreen();
    private boolean isHomeScreen = false;
    public SplashScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        getStage().addEventFilter(MouseEvent.MOUSE_CLICKED, eventEventHandler);
        PauseTransition delay = new PauseTransition(Duration.seconds(60));
        delay.setOnFinished(actionEvent -> openHomeScreen());
        delay.play();
    }
    private void removeHandler() {
        getStage().removeEventFilter(MouseEvent.MOUSE_CLICKED, eventEventHandler);
    }

    public void openHomeScreen() {
        if (isHomeScreen)
            return;
        isHomeScreen = true;
        HomeScreen homeScreen;
        try {
            homeScreen = new HomeScreen(getStage(), Config.HOME_SCREEN_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        homeScreen.display();
        homeScreen.setBController(new HomeController());
        homeScreen.setHomeScreen(homeScreen);
        removeHandler();
    }
}
