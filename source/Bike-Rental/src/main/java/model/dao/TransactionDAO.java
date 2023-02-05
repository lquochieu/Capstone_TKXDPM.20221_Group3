package model.dao;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import model.dao.connection.MySQL;
import model.entity.transaction.Transaction;
import utils.LogManager;
import utils.SQLCommand;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Mysql Transaction data access object implements {@link BaseDAO}
 *
 * @author Group 3
 */
@NoArgsConstructor
public class TransactionDAO implements BaseDAO<Transaction> {
    List<Transaction> transactions = new ArrayList<>();
    MySQL mySQL = MySQL.getDriverConnection();


    private Transaction extractTransaction(ResultSet res) throws SQLException {
        int bikeID = res.getInt("bikeID");
        int userID = res.getInt("userID");
        Transaction transaction = new Transaction(userID, bikeID);
        transaction.setId(res.getInt("id"));
        transaction.setStatus(res.getInt("status"));
        transaction.setDateTime(res.getTimestamp("dateTime").toLocalDateTime());
        return transaction;
    }

    private Transaction checkId(int id) {
        if (transactions.size() == 0) return null;
        for (Transaction transaction : transactions) {
            if (transaction.getId() == id) {
                return transaction;
            }
        }
        return null;
    }

    @Override
    public List<Transaction> getAll() {
        transactions.clear();
        String query = "SELECT * FROM bike_rental.transaction";
        LogManager.log.info(query);
        ResultSet res = mySQL.query(query);
        try {
            if (res.next()) {
                Transaction transaction = this.extractTransaction(res);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    @Override
    public Transaction getByID(int userID) {
        Transaction transaction = null;
        ResultSet res = mySQL.query(SQLCommand.QUERY_LATEST_TRANSACTION_BY_USER_ID, userID);
        try {
            if (res.next()) {
                transaction = this.extractTransaction(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    @Override
    public int save(Transaction transaction) {
        int id = mySQL.insert(SQLCommand.CREATE_TRANSACTION, new ArrayList<>(Arrays.asList(transaction.getUserId(),
                transaction.getBikeId(), transaction.getStatus(), transaction.getDateTime(), transaction.getTotalTime())));
        return id;
    }

    public void updateStatus(int id, float totalTime) {
        mySQL.update(SQLCommand.UPDATE_TRANSACTION_STATUS, new ArrayList<>(Arrays.asList(totalTime, id)));
    }

    @Override
    public void delete(Transaction t) {
        // TODO Auto-generated method stub

    }

    @SneakyThrows
    public Transaction getTransactionByUserID(int userID) {
        ResultSet res = mySQL.query(SQLCommand.QUERY_LATEST_TRANSACTION_BY_USER_ID, userID);
        if (res.next()) {
            return extractTransaction(res);
        }
        return null;
    }
}
