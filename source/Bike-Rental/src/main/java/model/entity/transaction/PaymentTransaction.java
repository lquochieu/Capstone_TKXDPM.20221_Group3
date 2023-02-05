package model.entity.transaction;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * entity payment transaction class
 *
 * @author Group 3
 */
@Getter
@Setter
public class PaymentTransaction {
    private int id;
    private String errorCode;
    private String category;
    private String cardID;
    private int transactionId;
    private String content;
    private int amount;
    private LocalDateTime createdAt;

    public PaymentTransaction(String errorCode, String category, String cardID, String content, int amount, LocalDateTime createdAt) {
        this.errorCode = errorCode;
        this.category = category;
        this.cardID = cardID;
        this.content = content;
        this.amount = amount;
        this.createdAt = createdAt;
    }
}