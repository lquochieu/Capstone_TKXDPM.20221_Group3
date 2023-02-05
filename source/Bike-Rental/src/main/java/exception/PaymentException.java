package exception;

/**
 * Payment Exception
 *
 * @author Group 3
 */

public class PaymentException extends RuntimeException {
    protected AlertPopup alertPopup = new AlertPopup();

    public PaymentException(String s) {
        super(s);
        alertPopup.show(s);
    }
}
