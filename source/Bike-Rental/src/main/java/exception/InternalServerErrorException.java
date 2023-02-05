package exception;

;

/**
 * Internal server exception
 *
 * @author Group 3
 */

public class InternalServerErrorException extends PaymentException {

    public InternalServerErrorException() {
        super("ERROR: Internal Server Error!");
    }

}
