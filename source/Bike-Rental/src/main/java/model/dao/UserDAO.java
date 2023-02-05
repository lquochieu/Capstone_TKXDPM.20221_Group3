package model.dao;

import lombok.NoArgsConstructor;
import model.dao.connection.MySQL;
import model.entity.user.User;
import utils.LogManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Mysql User data access object implements {@link BaseDAO}
 *
 * @author Group 3
 */
@NoArgsConstructor
public class UserDAO implements BaseDAO<User> {
    List<User> users = new ArrayList<>();
    MySQL mySQL = MySQL.getDriverConnection();

    /***
     *
     * @param res result set from mysql tools
     * @return User
     * @throws SQLException SQLException
     */
    private User extractUser(ResultSet res) throws SQLException {
        int id = res.getInt("id");
        String name = res.getNString("name");
        User user = new User(id, name);
        return user;
    }

    private User checkId(int id) {
        if (users.size() == 0) return null;
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        users.clear();
        String query = "SELECT * From bike_rental.user";
        ResultSet res = mySQL.query(query);
        try {
            while (res.next()) {
                User user = this.extractUser(res);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getByID(int id) {
        User user = this.checkId(id);
        if (user == null) {
            String query = "SELECT DISTINCT * FROM bike_rental.user where user.id=" + id;
            LogManager.log.info(query);
            ResultSet res = mySQL.query(query);
            try {
                user = this.extractUser(res);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public int save(User t) {
        // TODO Auto-generated method stub

        return 0;
    }

    @Override
    public void delete(User t) {
        // TODO Auto-generated method stub

    }

}
