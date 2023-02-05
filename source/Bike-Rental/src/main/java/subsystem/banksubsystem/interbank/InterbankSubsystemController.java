package subsystem.banksubsystem.interbank;

import exception.*;
import model.entity.card.Card;
import model.entity.transaction.PaymentTransaction;
import utils.UserInfo;

import java.time.LocalDateTime;

/**
 * Class implement API for pay, refund, reset Card
 *
 * @author Group 3
 * @version 1.0
 */

public class InterbankSubsystemController {
    private static final InterbankBoundary interbankBoundary = new InterbankBoundary();

    /**
     * query and get a Payment Transaction
     *
     * @param card     a singleton object
     * @param amount   number money
     * @param contents content for transaction
     * @return a {@link PaymentTransaction}
     */
    public PaymentTransaction pay(Card card, int amount, String contents) throws PaymentException {
        return extractPaymentTransaction(card, amount, contents);
    }

    /**
     * query and refund transaction
     *
     * @param card     a singleton object
     * @param amount   number money
     * @param contents content for transaction
     * @return a {@link PaymentTransaction}
     */
    public PaymentTransaction refund(Card card, int amount, String contents) throws PaymentException {
        return extractPaymentTransaction(card, -amount, contents);
    }


    private PaymentTransaction extractPaymentTransaction(Card card, int amount, String contents) throws PaymentException {
        String errCode = interbankBoundary.checkCard(card);
        if (errCode.equals("00")) {
            if (amount > UserInfo.balance) {
                errCode = "02";
            }
        }
        switch (errCode) {
            case "00":
                break;
            case "01":
                throw new InvalidCardException();
            case "02":
                throw new NotEnoughBalanceException();
            case "03":
                throw new InternalServerErrorException();
            case "04":
                throw new SuspiciousTransactionException();
            case "05":
                throw new NotEnoughTransactionInfoException();
            case "06":
                throw new InvalidVersionException();
            case "07":
                throw new InvalidTransactionAmountException();
            default:
                throw new UnrecognizedException();
        }
        UserInfo.balance -= amount;
        if (amount > 0)
            return new PaymentTransaction(errCode, "pay", card.getId(), contents, amount, LocalDateTime.now());
        else return new PaymentTransaction(errCode, "refund", card.getId(), contents, -amount, LocalDateTime.now());
    }
}
