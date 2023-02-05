package model.dao.bike;

import lombok.SneakyThrows;
import model.entity.bike.Bike;
import model.entity.bike.BikeView;
import model.entity.bike.ElectricBicycle;
import utils.SQLCommand;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Mysql Electric bike data access object extends {@link BikeDAO}
 *
 * @author Group 3
 */
public class ElectricBicycleDAO extends BikeDAO {

    @Override
    protected BikeView extractBike(ResultSet res) throws SQLException {
        int id = res.getInt("id");
        int type = res.getInt("type");
        int value = res.getInt("value");
        int dockId = res.getInt("dockID");
        String barcode = res.getNString("barcode");
        boolean status = res.getBoolean("status");
        String licensePlate = res.getNString("licensePlate");
        int battery = res.getInt("battery");
        Bike bike = new ElectricBicycle(id, type, value, dockId, barcode, status, licensePlate, battery);
        return new BikeView(bike, battery, licensePlate);
    }

    @SneakyThrows
    @Override
    public BikeView getByID(int id) {
        BikeView bike = null;
        ResultSet res = mySQL.query(SQLCommand.QUERY_E_BICYCLE_BY_ID, id);
        if (res.next()) {
            bike = extractBike(res);
        }
        return bike;
    }

    @SneakyThrows
    @Override
    public List<BikeView> getActiveBike(int dockID) {
        bikes.clear();
        ResultSet res = mySQL.query(SQLCommand.QUERY_ACTIVE_E_BICYCLE_LIST_BY_DOCK_ID, dockID);
        while (res.next()) {
            bikes.add(extractBike(res));
        }
        return bikes;
    }

    @SneakyThrows
    @Override
    public BikeView getByCode(String code) {
        BikeView bike = null;
        ResultSet res = mySQL.query(SQLCommand.QUERY_E_BICYCLE_BY_CODE, code);
        if (res.next()) {
            bike = extractBike(res);
        }
        return bike;
    }

    @SneakyThrows
    @Override
    public int getNumSpecBike(int dockID) {
        int i = 0;
        ResultSet res = mySQL.query(SQLCommand.QUERY_NUM_ACTIVE_E_BICYCLE_BY_DOCK_ID, dockID);
        if (res.next()) {
            i = res.getInt(1);
        }
        return i;
    }
}
