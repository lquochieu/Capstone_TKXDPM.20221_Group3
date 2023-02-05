package controller.barcode;

import controller.BaseController;
import model.dao.bike.BikeDaoFactory;
import model.entity.bike.BikeView;
import subsystem.barcodesubsystem.BarcodeSubsystem;

/**
 * @author Group 3
 */
 
public class BarcodeController extends BaseController {
    BarcodeSubsystem barcodeSubsystem = new BarcodeSubsystem();
    BikeDaoFactory bikeDaoFactory = new BikeDaoFactory();

    public BikeView processBarcode(String barcode) {
        String code = getBikeCode(barcode);
        return bikeDaoFactory.bikeDAOByCode(code).getByCode(code);
    }

    public String getBikeCode(String barcode) {
        return this.barcodeSubsystem.exchangeBarcode(barcode);
    }

}
