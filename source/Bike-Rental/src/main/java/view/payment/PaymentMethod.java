package view.payment;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import model.entity.transaction.Transaction;
import utils.Config;
import view.BaseScreen;

import java.io.IOException;

public class PaymentMethod extends BaseScreen {

    private Transaction transaction;
    private int amount;

    public PaymentMethod(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public void Initialize(Transaction transaction, int amount) throws IOException {
        this.transaction = transaction;
        this.amount = amount;
    }

    public void confirm(ActionEvent actionEvent) throws Exception {
        PaymentForm paymentForm = new PaymentForm(this.stage, Config.PAYMENT_FORM_PATH);
        paymentForm.setBController(getBController());
        paymentForm.setPreviousScreen(this);
        paymentForm.Initialize(transaction, amount);
        paymentForm.display();
    }

    public void back(ActionEvent actionEvent) {
        getPreviousScreen().display();
    }
}
