package view.dock;

import controller.bike.ReturnBikeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entity.dock.Dock;
import model.entity.invoice.Invoice;
import model.entity.invoice.InvoiceView;
import utils.Config;
import utils.Message;
import view.BaseContent;
import view.invoice.InvoiceScreen;

import java.io.IOException;

/**
 * view each dock in list docks when return bike
 *
 * @author Group 3
 */
public class DockReturnItem extends BaseContent {

    @FXML
    private Label name;
    @FXML
    private Label address;
    @FXML
    private Label numBlank;
    @FXML
    private Label status;
    @FXML
    private Label distance;
    @FXML
    private Button returnButton;

    private Dock dock;

    public DockReturnItem(String contentPath) throws IOException {
        super(contentPath);
    }

    public ReturnBikeController getBaseController() {
        return (ReturnBikeController) super.getBaseController();
    }

    public void Initialize(Dock dock) {
        this.dock = dock;
        name.setText(dock.getName());
        address.setText(dock.getAddress());
        status.setText(dock.getStatusString());
        int num = getBaseController().getNumBlank(dock);
        returnButton.setDisable(!dock.isStatus() || num <= 0);
        numBlank.setText(String.valueOf(num));
    }

    public void returnBike(ActionEvent actionEvent) throws IOException {
        InvoiceView invoiceView = getBaseController().processReturnBike(dock);
        InvoiceScreen invoiceScreen = new InvoiceScreen(new Stage(), Config.INVOICE_SCREEN_PATH);
        invoiceScreen.setBController(getBaseController());
        invoiceScreen.Initialize(invoiceView);
        getBaseScreen().getHomeScreen().display();
        invoiceScreen.display();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, Message.RETURN_BIKE_SUCCESSFULLY);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.show();
    }
}
