package view;

import controller.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.Config;
import view.home.HomeScreen;
import view.home.AboutUs;

import java.io.IOException;

/**
 * @author Group 3
 */
public class BaseScreen extends FXMLScreen {

    private static HomeScreen homeScreen;
    protected final Stage stage;
    private Scene scene;
    private BaseScreen prev;
    private BaseController bController;
    AboutUs aboutUs = new AboutUs(Config.ABOUT_US_PATH);

    public BaseScreen(Stage stage, String screenPath) throws IOException {
        super(screenPath);
        this.stage = stage;
        this.stage.setResizable(false);
    }

    public BaseScreen getPreviousScreen() {
        return this.prev;
    }

    public void setPreviousScreen(BaseScreen prev) {
        this.prev = prev;
    }

    public void display() {
        if (this.scene == null) {
            this.scene = new Scene(this.content);
        }
        this.stage.setScene(this.scene);
        this.stage.show();
        stage.setX((Config.screenWidth - stage.getWidth()) / 2);
        stage.setY((Config.screenHeight - stage.getHeight()) / 2);
    }

    public void setScreenTitle(String string) {
        this.stage.setTitle(string);
    }

    public BaseController getBController() {
        return this.bController;
    }

    public void setBController(BaseController bController) {
        this.bController = bController;
    }

    public HomeScreen getHomeScreen() {
        return homeScreen;
    }

    public void setHomeScreen(HomeScreen homeScreen) {
        BaseScreen.homeScreen = homeScreen;
    }

    public Stage getStage() {
        return this.stage;
    }

    public void returnHome() throws IOException {
        getHomeScreen().display();
    }

    public void aboutUs(MouseEvent mouseEvent) throws IOException {
        if (((Pane) getContent()).getChildren().contains(aboutUs.getContent())) {
            removeChild(aboutUs.getContent());
            return;
        }
        aboutUs.setBaseScreen(this);
        ((Pane) getContent()).getChildren().add(aboutUs.getContent());
        aboutUs.getContent().setLayoutX(262);
        aboutUs.getContent().setLayoutY(60);

    }

    public void contact(MouseEvent mouseEvent) {
        System.out.println("contact");
    }

    public void help(MouseEvent mouseEvent) {
        System.out.println("help");
    }

    public void resetCard(ActionEvent actionEvent) {
        getBController().resetCard();
    }
}