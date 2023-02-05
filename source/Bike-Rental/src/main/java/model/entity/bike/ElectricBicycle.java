package model.entity.bike;

import lombok.Getter;
import lombok.Setter;

/**
 * entity electric bicycle class
 *
 * @author Group 3
 */
@Getter
@Setter
public class ElectricBicycle extends Bike {
    private int battery;
    private String licensePlate;

    public ElectricBicycle(int id, int type, int value, int dockId, String barcode, boolean status, String licensePlate, int battery) {
        super(id, type, value, dockId, barcode, status);
        this.licensePlate = licensePlate;
        this.battery = battery;
    }
}
