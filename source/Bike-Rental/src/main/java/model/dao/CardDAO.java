package model.dao;

import lombok.SneakyThrows;
import model.dao.connection.MySQL;
import model.entity.card.Card;
import model.entity.card.CreditCard;
import utils.SQLCommand;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Mysql Card data access object implements {@link BaseDAO}
 *
 * @author Group 3
 */
public class CardDAO {

    MySQL mySQL = MySQL.getDriverConnection();

    @SneakyThrows
    public Card getByTransactionID(int transactionID) {
        ResultSet res = mySQL.query(SQLCommand.QUERY_CARD_BY_TRANSACTION_ID, transactionID);
        return extractCard(res);
    }

    public Card getByID(String cardID) throws SQLException {
        ResultSet res = mySQL.query(SQLCommand.QUERY_CARD_BY_ID, cardID);
        return extractCard(res);
    }

    private Card extractCard(ResultSet res) throws SQLException {
        if (res.next()) {
            String id = res.getString("id");
            int userID = res.getInt("userID");
            String issuingBank = res.getString("issuingBank");
            String owner = res.getString("owner");
            String cvv = res.getString("cvv");
            String method = res.getString("method");
            LocalDate dateTime = res.getDate("dateExpiration").toLocalDate();
            Card card = new CreditCard(id, userID, issuingBank, owner, cvv, dateTime);
            return card;
        }
        return null;
    }
}
