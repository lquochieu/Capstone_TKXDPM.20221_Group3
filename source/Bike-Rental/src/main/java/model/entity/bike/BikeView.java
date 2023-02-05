package model.entity.bike;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Bike info displayed in screen
 * @author Group 3
 */
@Getter
@Setter
@AllArgsConstructor
public class BikeView {
    private Bike bike;
    private Integer battery;
    private String licensePlate;

    public BikeView(Bike bike) {
        this.bike = bike;
    }
}
