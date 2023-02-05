package model.entity.bike;

import controller.calculateMoney.Calculator;
import lombok.Getter;
import lombok.Setter;
import model.dao.bike.BikeDaoFactory;

/**
 * entity bike class
 *
 * @author Group 3
 */
@Getter
@Setter
public abstract class Bike {
    protected int id;
    protected int type;
    protected int value;
    protected String barcode;
    protected boolean status;
    protected int dockId;

    public Bike(int id, int type, int value, int dockId, String barcode, boolean status) {
        super();
        this.id = id;
        this.type = type;
        this.value = value;
        this.dockId = dockId;
        this.barcode = barcode;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bike [id=" + id + ", type=" + type + ", value=" + value
                + ", dockId=" + dockId + ", barcode=" + barcode + "]";
    }

    public int getDeposit() {
        return new Calculator().getDeposit(this.value);
    }

    public String getTypeString() {
        for (BikeDaoFactory.BikeType bikeType: BikeDaoFactory.BikeType.values()) {
            if (this.type == bikeType.getInt())
                return bikeType.toString();
        }
        return null;
    }
}

