package controller;


import model.dao.BaseDAO;
import model.dao.DockDAO;
import model.dao.TransactionDAO;
import model.entity.dock.Dock;
import model.entity.transaction.Transaction;
import model.entity.user.User;

import java.util.List;

public class HomeController extends BaseController {

    BaseDAO<Dock> dockDAO = new DockDAO();
    TransactionDAO transactionDAO = new TransactionDAO();

    public List<Dock> GetDockList() {
        return dockDAO.getAll();
    }

    public Transaction getTransaction() {
        return transactionDAO.getTransactionByUserID(User.getInstance().getId());
    }
}
