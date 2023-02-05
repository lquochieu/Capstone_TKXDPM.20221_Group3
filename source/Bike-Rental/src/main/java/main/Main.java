package main;

import controller.HomeController;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.Config;
import view.home.HomeScreen;
import view.home.SplashScreen;

import java.io.IOException;
import java.util.Locale;

/**
 * @author Group 3
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale.setDefault(Locale.ENGLISH);
        SplashScreen splashScreen = new SplashScreen(primaryStage, Config.SPLASH_SCREEN_PATH);
        splashScreen.display();
    }
}
