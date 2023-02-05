package view.payment;


import controller.payment.PaymentController;
import exception.InvalidCardException;
import exception.NotEnoughTransactionInfoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.DateTimeStringConverter;
import model.entity.card.Card;
import model.entity.transaction.PaymentTransaction;
import model.entity.transaction.Transaction;
import model.entity.user.User;
import utils.Config;
import utils.Message;
import view.BaseScreen;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PaymentForm extends BaseScreen implements Initializable {


    @FXML
    private TextField cardholderName;
    @FXML
    private TextField cardNumber;
    @FXML
    private DatePicker expirationDate;
    @FXML
    private TextField issuingBank;
    @FXML
    private TextField sercurityCode;
    @FXML
    private TextArea transactionContent;
    @FXML
    private Label amount;

    private Transaction transaction;

    public PaymentForm(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public PaymentController getBController() {
        return (PaymentController) super.getBController();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.cardholderName.setText(User.getInstance().getName());
        this.cardNumber.setText("kstn_group3_2022");
        this.issuingBank.setText("Vietinbank");
        this.sercurityCode.setText("12345");
        this.expirationDate.setValue(LocalDate.parse("2024-01-01"));
        this.transactionContent.setText(cardholderName.getText() + " deposit");
    }

    public void Initialize(Transaction transaction, int amount) throws IOException, ParseException {
        this.amount.setText(String.valueOf(amount));
        this.transaction = transaction;
    }

    public void confirm(ActionEvent actionEvent) throws IOException {
        checkTransactionInfo();
        PaymentTransaction paymentTransaction = getBController().deposit(cardNumber.getText(), issuingBank.getText(), cardholderName.getText(), sercurityCode.getText(), expirationDate.getValue(), Integer.parseInt(amount.getText()), transactionContent.getText());
        if (paymentTransaction.getErrorCode() == Config.noErrorCode) {
            int transactionId = getBController().saveTransaction(transaction);
            paymentTransaction.setTransactionId(transactionId);
            getBController().savePaymentTransaction(paymentTransaction);
            this.stage.close();
            returnHome();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, Message.RENT_BIKE_SUCCESSFULLY);
            alert.show();
        }
    }

    public void checkTransactionInfo() {
        if (cardholderName.getText().equals("") || cardNumber.getText().equals("") || issuingBank.getText().equals("") || sercurityCode.getText().equals("")) {
            throw new NotEnoughTransactionInfoException();
        }
        if (expirationDate.getValue().isBefore(LocalDate.now())) {
            throw new InvalidCardException();
        }
    }

    public void back(ActionEvent actionEvent) {
        getPreviousScreen().display();
    }
}