import exception.*;
import model.entity.card.Card;
import model.entity.card.CreditCard;
import model.entity.transaction.PaymentTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import subsystem.banksubsystem.interbank.InterbankBoundary;
import subsystem.banksubsystem.interbank.InterbankSubsystemController;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class InterbankSubsystemControllerTest {

    private InterbankBoundary interbankBoundary;
    private InterbankSubsystemController interbankSubsystemController;
    private Card card;
    @BeforeEach
    void setUp() {
        this.interbankBoundary = new InterbankBoundary();
        interbankSubsystemController = new InterbankSubsystemController();
        card = new CreditCard("12345678", 1, "VietinBank", "kstn_group3_2022", "12345", LocalDate.parse("2024-01-01"));
    }

    @ParameterizedTest
    @CsvSource ({
            "1000, 1000",
            "10000, 10000",
            "20000, 20000"
    })
    public void payRental(int amount, int expected) throws IOException, ParseException {
        PaymentTransaction a = interbankSubsystemController.pay(card, amount, "test");
        assertEquals(expected, a.getAmount());
    }
}