package model.entity.card;

import java.time.LocalDate;

/**
 * entity credit card class
 *
 * @author Group 3
 */
public class CreditCard extends Card {

    public CreditCard(String id, int userID, String issuingBank, String owner, String cvv, LocalDate dateExpire) {
        super(id, userID, issuingBank, owner, cvv, dateExpire, String.valueOf(0));
    }
}
