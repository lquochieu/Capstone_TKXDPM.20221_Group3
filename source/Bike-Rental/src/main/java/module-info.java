/**
 * @author Group 3
 */
 module Bike.Rental {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires mysql.connector.j;
    requires com.google.gson;
    requires java.sql;

    opens main to javafx.fxml;
    opens fxml.bike to javafx.fxml;
    opens fxml.barcode to javafx.fxml;
    opens fxml.dock to javafx.fxml;
    opens fxml.home to javafx.fxml;
    opens fxml.payment to javafx.fxml;
    opens fxml.invoice to javafx.fxml;
    opens view to javafx.fxml;
    opens view.dock to javafx.fxml;
    opens view.bike to javafx.fxml;
    opens view.barcode to javafx.fxml;
    opens view.home to javafx.fxml;
    opens view.invoice to javafx.fxml;
    opens view.payment to javafx.fxml;

    exports main to javafx.graphics;
    exports view.home to javafx.graphics;
    exports view.dock to javafx.graphics;
    exports view.bike to javafx.graphics;
    exports view.payment to javafx.graphics;
    exports view.barcode to javafx.graphics;
    exports view.invoice to javafx.graphics;

   exports subsystem.banksubsystem.interbank;
   exports subsystem.barcodesubsystem.barcode;
   exports model.entity.card;
   exports model.entity.transaction;
   exports exception;
}
