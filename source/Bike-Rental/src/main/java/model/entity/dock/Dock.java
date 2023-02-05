package model.entity.dock;

import lombok.Getter;
import lombok.Setter;

/**
 * entity dock class
 *
 * @author Group 3
 */
@Getter
@Setter
public class Dock {
    private int id;
    private String name;
    private String address;
    private String area;
    private boolean status;
    private int bikeAmount;

    @Override
    public String toString() {
        return "Dock " + name + " address " + address;
    }

    public String getStatusString() {
        if (status == true) {
            return "Opened";
        } else return "Closed";
    }

}
