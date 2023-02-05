package model.dao.connection;

import javafx.scene.control.Alert;
import utils.LogManager;
import utils.Message;

import java.sql.*;
import java.util.Collections;
import java.util.List;

/**
 * Connect to databases
 *
 * @author Group 3
 */

public class MySQL {
    private static MySQL instance;
    public Connection connection;
    private String url;
    private String dbName;
    private String driver;
    private String username;
    private String password;
    private Statement statement;

    private PreparedStatement preparedStatement;

    private MySQL() {
        this.url = "jdbc:mysql://localhost:3306/";
        this.dbName = "bike_rental";
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.username = "root";
        this.password = "tkxdpm2022";

        try {
            Class.forName(driver).newInstance();
            this.connection = (Connection) DriverManager.getConnection(url + dbName, username, password);
            System.out.println("Database connected!");
        } catch (Exception sql) {
            System.out.println("Database failed!");
            sql.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, Message.CONNECTION_FAILED);
            alert.show();
        }
    }

    /**
     * Singleton method
     *
     * @return an instance MySQLDriver
     */
    public static MySQL getDriverConnection() {
        if (MySQL.instance == null) {
            synchronized (MySQL.class) {
                if (instance == null) {
                    instance = new MySQL();
                }
            }
        }
        return MySQL.instance;
    }

    /**
     * query to mysql databases
     *
     * @param query a String
     * @return a ResultSet
     */

    public ResultSet query(String query) {
        ResultSet res = null;
        LogManager.log.info(query);
        try {
            statement = MySQL.instance.connection.createStatement();
            res = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ResultSet query(String query, Object object) {
        ResultSet res = null;
        try {
            preparedStatement = MySQL.instance.connection.prepareStatement(query);
            convertObject(Collections.singletonList(object));
            LogManager.log.info(preparedStatement.toString());
            res = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ResultSet query(String query, List<Object> objectList) {
        ResultSet res = null;
        try {
            preparedStatement = MySQL.instance.connection.prepareStatement(query);
            convertObject(objectList);
            res = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * insert to fb with query
     *
     * @param insertQuery a String
     * @return code for successful or fail
     */
    public int insert(String insertQuery) {
        int id = -1;
        try {
            this.statement = MySQL.instance.connection.createStatement();
            LogManager.log.info(insertQuery);
            id = this.statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            if (id > 0) {
                ResultSet res = this.statement.getGeneratedKeys();
                res.next();
                id = res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public int insert(String insertQuery, List<Object> objectList) {
        int id = -1;
        try {
            this.preparedStatement = MySQL.instance.connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            convertObject(objectList);
            id = preparedStatement.executeUpdate();
            if (id > 0) {
                ResultSet res = this.preparedStatement.getGeneratedKeys();
                res.next();
                id = res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    private void convertObject(List<Object> objectList) throws SQLException {
        for (int i = 0; i < objectList.size(); i++) {
            preparedStatement.setObject(i + 1, objectList.get(i));
        }
    }

    public void update(String updateQuery) {
        try {
            this.statement = MySQL.instance.connection.createStatement();
            this.statement.executeUpdate(updateQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String updateQuery, List<Object> objectList) {
        try {
            this.preparedStatement = MySQL.instance.connection.prepareStatement(updateQuery);
            convertObject(objectList);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
