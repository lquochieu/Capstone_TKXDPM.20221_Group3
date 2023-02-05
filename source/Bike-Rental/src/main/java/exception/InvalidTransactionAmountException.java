package exception;

;

/**
 * Invalid Transaction Amount Exception
 *
 * @author Group 3
 */

public class InvalidTransactionAmountException extends PaymentException {
    public InvalidTransactionAmountException() {
        super("ERROR: Invalid Transaction Amount!");
    }
}
