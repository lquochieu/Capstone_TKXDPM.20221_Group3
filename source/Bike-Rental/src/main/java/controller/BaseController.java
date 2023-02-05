package controller;

import model.entity.card.Card;
import subsystem.banksubsystem.InterbankSubsystem;

public class BaseController {

    InterbankSubsystem interbankSubsystem = new InterbankSubsystem();
    public void resetCard() {
        interbankSubsystem.resetCard();
    }
}
