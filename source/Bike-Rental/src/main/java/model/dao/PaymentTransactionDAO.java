package model.dao;

import lombok.NoArgsConstructor;
import model.dao.connection.MySQL;
import model.entity.transaction.PaymentTransaction;
import utils.SQLCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Mysql Payment transaction  data access object implements {@link BaseDAO}
 *
 * @author Group 3
 */
@NoArgsConstructor
public class PaymentTransactionDAO implements BaseDAO<PaymentTransaction> {
    MySQL mySQL = MySQL.getDriverConnection();

    @Override
    public List<PaymentTransaction> getAll() {
        return null;
    }

    @Override
    public PaymentTransaction getByID(int id) {
        return null;
    }

    @Override
    public int save(PaymentTransaction paymentTransaction) {
        int id = mySQL.insert(SQLCommand.CREATE_PAYMENT_TRANSACTION, new ArrayList<>(Arrays.asList(paymentTransaction.getErrorCode(),
                paymentTransaction.getTransactionId(), paymentTransaction.getCategory(), paymentTransaction.getCardID(), paymentTransaction.getContent(), paymentTransaction.getAmount(), paymentTransaction.getCreatedAt())));
        return id;
    }

    @Override
    public void delete(PaymentTransaction paymentTransaction) {

    }
}
