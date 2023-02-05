package subsystem.barcodesubsystem.barcode;

import exception.InvalidBarcodeException;
import model.dao.bike.BikeDaoFactory;

/**
 * Class implement API for exchange Barcode subsystem
 *
 * @author Group 3
 * @version 1.0
 */

public class BarcodeController {
    /**
     * API instances for Barcode Controller
     */
    BarcodeBoundary barcodeBoundary = new BarcodeBoundary();

    public String exchangeBarcode(String barcode) {
        BikeDaoFactory bikeDaoFactory = new BikeDaoFactory();
        if (bikeDaoFactory.bikeDAOByCode(barcode) == null) {
            throw new InvalidBarcodeException();
        }
        return barcode;
    }
}
