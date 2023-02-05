package exception;

/**
 * Invalid barcode exception
 *
 * @author Group 3
 */
public class InvalidBarcodeException extends RuntimeException {
    private AlertPopup alertPopup = new AlertPopup();

    public InvalidBarcodeException() {
        alertPopup.show("ERROR: INVALID BARCODE!");
    }
}
