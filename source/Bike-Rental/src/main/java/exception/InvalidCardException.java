package exception;

;

/**
 * Invalid Card Exception
 *
 * @author Group 3
 */

public class InvalidCardException extends PaymentException {
    public InvalidCardException() {
        super("ERROR: Invalid card!");
    }
}
