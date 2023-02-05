package utils;

/**
 * constant SQL command
 *
 * @author Group 3
 */
public class SQLCommand {

    /********************************************************************************
    *                                                                               *
    *                                    DOCK commands                              *
    *                                                                               *
    ********************************************************************************/
    public static final String QUERY_DOCK_LIST = "SELECT * FROM Dock";

    public static final String QUERY_DOCK_BY_ID = "SELECT DISTINCT * FROM Dock WHERE Dock.id = ?";

    public static final String QUERY_NUM_ACTIVE_BIKE_BY_DOCK_ID = "SELECT COUNT(*) " +
            "FROM Bike " +
            "WHERE Bike.dockID = ? and Bike.status = 1";

    /********************************************************************************
    *                                                                               *
    *                                    Bike commands                              *
    *                                                                               *
    ********************************************************************************/
    public static final String QUERY_ACTIVE_BICYCLE_LIST_BY_DOCK_ID = "SELECT * " +
            "FROM Bike, Bicycle " +
            "WHERE Bike.id = Bicycle.id " +
            "and Bike.status = 1 and Bike.dockID = ? ";

    public static final String QUERY_ACTIVE_E_BICYCLE_LIST_BY_DOCK_ID = "SELECT * " +
            "FROM Bike, ElectricBicycle " +
            "WHERE Bike.id = ElectricBicycle.id " +
            "and Bike.status = 1 and Bike.dockID = ?";

    public static final String QUERY_ACTIVE_TANDEM_LIST_BY_DOCK_ID = "SELECT * " +
            "FROM Bike, Tandem " +
            "WHERE Bike.id = Tandem.id " +
            "and Bike.status = 1 and Bike.dockID = ?";
    public static final String QUERY_NUM_ACTIVE_BICYCLE_BY_DOCK_ID = "SELECT COUNT(*) " +
            "FROM Bike, Bicycle " +
            "WHERE Bike.id = Bicycle.id " +
            "and Bike.status = 1 and Bike.dockID = ?";
    public static final String QUERY_NUM_ACTIVE_TANDEM_BY_DOCK_ID = "SELECT COUNT(*) " +
            "FROM Bike, Tandem " +
            "WHERE Bike.id = Tandem.id " +
            "and Bike.status = 1 and Bike.dockID = ?";
    public static final String QUERY_NUM_ACTIVE_E_BICYCLE_BY_DOCK_ID = "SELECT COUNT(*) " +
            "FROM Bike, ElectricBicycle " +
            "WHERE Bike.id = ElectricBicycle.id " +
            "and Bike.status = 1 and Bike.dockID = ?";
    public static final String QUERY_BIKE_TYPE_BY_CODE = "SELECT Bike.type " +
            "FROM Bike " +
            "WHERE Bike.barcode = ?";

    public static final String QUERY_BICYCLE_BY_ID = "SELECT * " +
            "FROM Bike, Bicycle " +
            "WHERE Bike.id = Bicycle.id " +
            "and Bike.id = ?";

    public static final String QUERY_TANDEM_BY_ID = "SELECT * " +
            "FROM Bike, Tandem " +
            "WHERE Bike.id = Tandem.id " +
            "and Bike.id = ?";

    public static final String QUERY_E_BICYCLE_BY_ID = "SELECT * " +
            "FROM Bike, ElectricBicycle " +
            "WHERE Bike.id = ElectricBicycle.id " +
            "and Bike.id = ?";

    public static final String QUERY_BICYCLE_BY_CODE = "SELECT * " +
            "FROM Bike, Bicycle " +
            "WHERE Bike.id = Bicycle.id " +
            "and Bike.barcode = ?";

    public static final String QUERY_TANDEM_BY_CODE = "SELECT * " +
            "FROM Bike, Tandem " +
            "WHERE Bike.id = Tandem.id " +
            "and Bike.barcode = ?";

    public static final String QUERY_E_BICYCLE_BY_CODE = "SELECT * " +
            "FROM Bike, ElectricBicycle " +
            "WHERE Bike.id = ElectricBicycle.id " +
            "and Bike.barcode = ?";

    public static final String QUERY_BIKE_TYPE_BY_ID = "SELECT Bike.type " +
            "FROM Bike " +
            "WHERE Bike.id = ?";

    public static final String UPDATE_STATUS_BIKE_BY_BIKE_ID = "UPDATE Bike " +
            "SET Bike.status = ? " +
            "WHERE Bike.id = ?";
    
    public static final String UPDATE_BIKE_RETURN = "Update Bike " +
            "SET status = 1, dockID = ? " +
            "WHERE id = ?";

    /********************************************************************************
    *                                                                               *
    *                                    Card commands                              *
    *                                                                               *
    ********************************************************************************/
    public static final String QUERY_CARD_BY_ID = "SELECT DISTINCT * FROM Card WHERE Card.id = ?";
    public static final String QUERY_CARD_BY_TRANSACTION_ID = "SELECT DISTINCT Card.* " +
            "FROM Card, Transaction t, PaymentTransaction pt " +
            "WHERE Card.id = pt.cardID and t.id = pt.transactionID " +
            "and t.id = ?";

    /********************************************************************************
    *                                                                               *
    *                                Transaction commands                           *
    *                                                                               *
    ********************************************************************************/

    public static final String CREATE_TRANSACTION = "INSERT INTO Transaction (userId, bikeId, status, dateTime, totalTime) " +
            "VALUES (?,?,?,?,?)";
    public static final String QUERY_LATEST_TRANSACTION_BY_USER_ID = "SELECT * " +
            "FROM Transaction " +
            "WHERE userID = ? " +
            "ORDER BY id DESC LIMIT 1";

   /********************************************************************************
    *                                                                               *
    *                             Payment transaction commands                      *
    *                                                                               *
    ********************************************************************************/
    public static final String CREATE_PAYMENT_TRANSACTION = "INSERT INTO PaymentTransaction (errorCode, transactionId, category, cardID, content, amount, createAt) " +
            "VALUES (?,?,?,?,?,?,?)";

    public static final String CREATE_INVOICE = "INSERT INTO Invoice (paymentTransactionID, returnDockID) " +
            "VALUES (?, ?)";

    public static final String UPDATE_TRANSACTION_STATUS = "Update Transaction " +
            "SET status = 0, totalTime = ? " +
            "WHERE id = ?";

}
