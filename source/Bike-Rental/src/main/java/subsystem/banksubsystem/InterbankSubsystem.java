package subsystem.banksubsystem;


import exception.PaymentException;
import model.entity.card.Card;
import model.entity.transaction.PaymentTransaction;
import subsystem.banksubsystem.interbank.InterbankSubsystemController;
import utils.UserInfo;

/***
 * The {@code InterbankSubsystem} class is used to communicate with the
 * Interbank to make transaction.
 *
 * @author Group3
 *
 */

public class InterbankSubsystem implements InterbankInterface {

    /**
     * Represent the controller of the subsystem
     */
    private InterbankSubsystemController interbankSubsystemController;

    /**
     * Initializes a newly created {@link InterbankSubsystemController} object so that it
     * represents an Interbank subsystem.
     */
    public InterbankSubsystem() {
        this.interbankSubsystemController = new InterbankSubsystemController();
    }

    /**
     * @param card     - the credit card used for payment
     * @param amount   - the amount to pay
     * @param contents - content for transaction
     * @return return a respond {@link PaymentTransaction PaymentTransaction}
     * @throws PaymentException PaymentException
     */
    public PaymentTransaction pay(Card card, int amount, String contents) throws PaymentException {
        PaymentTransaction transaction = interbankSubsystemController.pay(card, amount, contents);
        return transaction;
    }

    /**
     * @param card     - the credit card which would be refunded to
     * @param amount   - the amount to refund
     * @param contents - content for transaction
     * @return return a respond {@link PaymentTransaction PaymentTransaction}
     * @throws PaymentException PaymentException
     */
    public PaymentTransaction refund(Card card, int amount, String contents) throws PaymentException {
        PaymentTransaction transaction = interbankSubsystemController.refund(card, amount, contents);
        return transaction;
    }

    @Override
    public void resetCard() {
        UserInfo.balance = 1000000;
    }
}
