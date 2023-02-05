package exception;

;

/**
 * Invalid Version Exception
 *
 * @author Group 3
 */

public class InvalidVersionException extends PaymentException {
    public InvalidVersionException() {
        super("ERROR: Invalid Version Information!");
    }
}
