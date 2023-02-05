package model.entity.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * entity card class
 *
 * @author Group 3
 */
@AllArgsConstructor
@Getter
@Setter
public abstract class Card {
    protected String id;
    protected int userID;
    protected String owner;
    protected String issuingBank;
    protected String cvv;
    protected LocalDate dateExpire;
    protected String method;
}
