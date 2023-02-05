package controller.dock;

import controller.BaseController;
import model.dao.bike.BikeDaoFactory;
import model.entity.bike.BikeView;

import java.util.List;

public class DockDetailController extends BaseController {
    BikeDaoFactory bikeDaoFactory = new BikeDaoFactory();

    public List<BikeView> getAllBike(int dockID, int bikeType) {

        return bikeDaoFactory.bikeDaoByType(bikeType).getActiveBike(dockID);
    }

    public int getNumSpecBike(int dockID, int bikeType) {
        return bikeDaoFactory.bikeDaoByType(bikeType).getNumSpecBike(dockID);
    }
}
