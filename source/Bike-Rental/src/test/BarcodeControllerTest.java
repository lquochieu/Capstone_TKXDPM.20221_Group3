import subsystem.barcodesubsystem.barcode.BarcodeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarcodeControllerTest {
    private BarcodeController barcodeController;

    @BeforeEach
    void setUp() {
        barcodeController = new BarcodeController();
    }

    @ParameterizedTest
    @CsvSource({
            "12345,12345",
            "12346,12346",
            "12347,12347"
    })
    public void validateBarcode(String barcode, String expected) {
        String isValid = barcodeController.exchangeBarcode(barcode);
        assertEquals(expected, isValid);
    }
}