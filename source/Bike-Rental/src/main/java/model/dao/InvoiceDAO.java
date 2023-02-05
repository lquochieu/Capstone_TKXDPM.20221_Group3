package model.dao;

import model.dao.connection.MySQL;
import model.entity.invoice.Invoice;
import utils.SQLCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Mysql Invoice data access object implements {@link BaseDAO}
 *
 * @author Group 3
 */
public class InvoiceDAO implements BaseDAO<Invoice> {

    MySQL mySQL = MySQL.getDriverConnection();

    @Override
    public List<Invoice> getAll() {
        return null;
    }

    @Override
    public Invoice getByID(int id) {
        return null;
    }

    @Override
    public int save(Invoice invoice) {
        return mySQL.insert(SQLCommand.CREATE_INVOICE, new ArrayList<>(Arrays.asList(
                invoice.getPaymentTransactionID(), invoice.getReturnDockID())));
    }

    @Override
    public void delete(Invoice invoice) {

    }
}
