package exception;

/**
 * Not Enough Transaction Info Exception
 *
 * @author Group 3
 */

public class NotEnoughTransactionInfoException extends PaymentException {
    public NotEnoughTransactionInfoException() {
        super("ERROR: Not Enough Transcation Information");
    }
}
