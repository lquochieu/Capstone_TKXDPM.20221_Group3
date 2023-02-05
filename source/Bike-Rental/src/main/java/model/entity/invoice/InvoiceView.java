package model.entity.invoice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Invoice info displayed in screen
 * @author Group 3
 */
@AllArgsConstructor
@Getter
@Setter
public class InvoiceView {
    private String rentalName;
    private String cardNumber;
    private LocalDate dateExpired;
    private String bikeType;
    private String rentalDock;
    private String returnDock;
    private int rentalTime;
    private int rentalAmount;
    private int deposit;
    private int refundAmount;
}
