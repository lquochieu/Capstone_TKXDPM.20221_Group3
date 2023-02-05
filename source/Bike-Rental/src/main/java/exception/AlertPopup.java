package exception;

import javafx.scene.control.Alert;
import javafx.stage.Modality;

/**
 * Show alert exception
 *
 * @author Group 3
 */
 
public class AlertPopup {
    Alert alert = new Alert(Alert.AlertType.ERROR);

    public void show(String error) {
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setContentText(error);
        alert.show();
    }
}
