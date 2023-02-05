package model.entity.invoice;

import lombok.Getter;
import lombok.Setter;

/**
 * entity invoice class
 *
 * @author Group 3
 */
@Getter
@Setter
public class Invoice {
    private int id;
    private int paymentTransactionID;
    private int returnDockID;

    public Invoice(int paymentTransactionID, int returnDockID) {
        this.paymentTransactionID = paymentTransactionID;
        this.returnDockID = returnDockID;
    }
}
