package exception;

;

/**
 * Unrecognized Exception
 *
 * @author Group 3
 */

public class UnrecognizedException extends RuntimeException {
    public UnrecognizedException() {
        super("ERROR: Something went wrong!");
    }
}
