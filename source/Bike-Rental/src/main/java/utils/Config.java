package utils;

import javafx.stage.Screen;

/**
 * class provide path to app screens
 *
 * @author Group 3
 */
public class Config {

    // screen size
    public static final Double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
    public static final Double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
    public static final String noErrorCode = "00";
    public static final String refund = "refund";
    public static final String pay = "pay";

    // static resources
    public static final String SPLASH_SCREEN_PATH = "/fxml/home/SplashScreen.fxml";
    public static final String HOME_SCREEN_PATH = "/fxml/home/HomeScreen.fxml";
    public static final String ABOUT_US_PATH = "/fxml/home/AboutUs.fxml";
    public static final String DOCK_LIST_SCREEN_PATH = "/fxml/dock/DockListScreen.fxml";
    public static final String DOCK_DETAIL_SCREEN_PATH = "/fxml/dock/DockDetailScreen.fxml";
    public static final String DOCK_RETURN_SCREEN_PATH = "/fxml/dock/DockReturnScreen.fxml";
    public static final String DOCK_ITEM_PATH = "/fxml/dock/DockItem.fxml";
    public static final String DOCK_RETURN_ITEM_PATH = "/fxml/dock/DockReturnItem.fxml";
    public static final String BIKE_DETAIL_SCREEN_PATH = "/fxml/bike/BikeDetailScreen.fxml";
    public static final String BIKE_ITEM_PATH = "/fxml/bike/BikeItem.fxml";
    public static final String RENTAL_BIKE_DETAIL_SCREEN_PATH = "/fxml/bike/RentalBikeDetailScreen.fxml";
    public static final String BARCODE_PATH = "/fxml/barcode/Barcode.fxml";
    public static final String PAYMENT_FORM_PATH = "/fxml/payment/PaymentForm.fxml";
    public static final String PAYMENT_METHOD_PATH = "/fxml/payment/PaymentMethod.fxml";
    public static final String INVOICE_SCREEN_PATH = "/fxml/invoice/InvoiceScreen.fxml";
}
