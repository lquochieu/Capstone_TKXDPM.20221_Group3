package view.invoice;

import controller.bike.ReturnBikeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.robot.Robot;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.entity.invoice.Invoice;
import model.entity.invoice.InvoiceView;
import model.entity.user.User;
import utils.Config;
import utils.Utils;
import view.BaseScreen;

import java.io.IOException;

/**
 * view invoice
 *
 * @author Group 3
 */
public class InvoiceScreen extends BaseScreen {

    @FXML
    private Label rentalName;
    @FXML
    private Label cardNumber;
    @FXML
    private Label expirationDate;
    @FXML
    private Label bikeType;
    @FXML
    private Label rentalDock;
    @FXML
    private Label returnDock;
    @FXML
    private Label rentalTime;
    @FXML
    private Label rentalAmount;
    @FXML
    private Label deposit;
    @FXML
    private Label refundAmount;
    @FXML
    private Label refundLabel;

    public InvoiceScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public ReturnBikeController getBController() {
        return (ReturnBikeController) super.getBController();
    }

    public void Initialize(InvoiceView invoiceView) {
        rentalName.setText(User.getInstance().getName());
        cardNumber.setText(invoiceView.getCardNumber());
        expirationDate.setText(invoiceView.getDateExpired().toString());
        bikeType.setText(invoiceView.getBikeType());
        rentalDock.setText(invoiceView.getRentalDock());
        returnDock.setText(invoiceView.getReturnDock());
        rentalTime.setText(Utils.formatTime(invoiceView.getRentalTime()));
        deposit.setText(String.valueOf(invoiceView.getDeposit()));
        refundAmount.setText(String.valueOf(Math.abs(invoiceView.getRefundAmount())));
        if (invoiceView.getRefundAmount() >= 0) {
            refundLabel.setText("Refund amount:");
        }
        else {
            refundLabel.setText("Extra amount:");
        }
        rentalAmount.setText(String.valueOf(invoiceView.getDeposit() - invoiceView.getRefundAmount()));
    }

    public void saveInvoice(ActionEvent actionEvent) {

    }

    public void back(ActionEvent actionEvent) {
        this.stage.close();
    }
}
