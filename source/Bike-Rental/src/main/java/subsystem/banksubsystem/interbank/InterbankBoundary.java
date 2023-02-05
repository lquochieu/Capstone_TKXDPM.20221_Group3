package subsystem.banksubsystem.interbank;

import model.dao.CardDAO;
import model.entity.card.Card;

import java.sql.SQLException;

/**
 * Class provide API for query http/https
 *
 * @author Group 3
 * @version 1.0
 */

public class InterbankBoundary {
    CardDAO cardDAO = new CardDAO();

    public String checkCard(Card card) {
        String errorCode = "00";
        Card trueCard = null;
        try {
            trueCard = cardDAO.getByID(card.getId());
        } catch (SQLException e) {
            errorCode = "01";
        }
        if (
                trueCard == null ||
                        !trueCard.getIssuingBank().equals(card.getIssuingBank()) ||
                        trueCard.getUserID() != card.getUserID() ||
                        !trueCard.getCvv().equals(card.getCvv()) ||
                        !trueCard.getDateExpire().equals(card.getDateExpire())) {
            errorCode = "01";
        }
        return errorCode;
    }

}
