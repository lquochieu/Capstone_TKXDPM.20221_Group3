package model.dao.bike;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import model.dao.BaseDAO;
import model.dao.connection.MySQL;
import model.entity.bike.BikeView;
import utils.SQLCommand;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Mysql Bike data access object implements {@link BaseDAO}
 *
 * @author Group 3
 */
@NoArgsConstructor
public abstract class BikeDAO implements BaseDAO<BikeView> {
    List<BikeView> bikes = new ArrayList<>();
    MySQL mySQL = MySQL.getDriverConnection();

    protected abstract BikeView extractBike(ResultSet res) throws SQLException;

    @SneakyThrows
    @Override
    public List<BikeView> getAll() {
        return null;
    }

    @Override
    public abstract BikeView getByID(int id);

    public abstract List<BikeView> getActiveBike(int dockID);

    public abstract BikeView getByCode(String code);

    public abstract int getNumSpecBike(int dockID);

    public void updateStatus(int bikeID, int status) {
        mySQL.update(SQLCommand.UPDATE_STATUS_BIKE_BY_BIKE_ID, new ArrayList<>(Arrays.asList(status, bikeID)));
    }

    public void updateReturnBike(int bikeID, int dockID) {
        mySQL.update(SQLCommand.UPDATE_BIKE_RETURN, new ArrayList<>(Arrays.asList(dockID, bikeID)));
    }

    @Override
    public int save(BikeView bike) {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public void delete(BikeView bike) {
        // TODO Auto-generated method stub

    }

}
