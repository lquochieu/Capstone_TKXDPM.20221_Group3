package subsystem.barcodesubsystem;

import subsystem.barcodesubsystem.barcode.BarcodeController;

/**
 * A class implement {@link BarcodeInterface}
 *
 * @author Group 3
 */

public class BarcodeSubsystem implements BarcodeInterface {
    private BarcodeController barcodeController;


    public BarcodeSubsystem() {
        this.barcodeController = new BarcodeController();
    }

    /**
     * Override method
     *
     * @param barcode a {@link String} barcode
     * @return a {@link String} describe Bike barcode
     */
    @Override
    public String exchangeBarcode(String barcode) {
        return this.barcodeController.exchangeBarcode(barcode);
    }
}
