package model.dao.bike;

import lombok.SneakyThrows;
import model.dao.connection.MySQL;
import model.entity.bike.BikeView;
import utils.SQLCommand;

import java.sql.ResultSet;

/**
 * Get BikeDAO of each Bike type
 * @author Group 3
 */
public class BikeDaoFactory {
    static BikeDAO bicycleDAO = new BicycleDAO();
    static BikeDAO tandemDAO = new TandemDAO();
    static BikeDAO electricBicycleDAO = new ElectricBicycleDAO();
    MySQL mySQL = MySQL.getDriverConnection();

    public BikeDAO bikeDaoByType(int type) {
        for (BikeType bikeType: BikeType.values()) {
            if (bikeType.getInt() == type) {
                return bikeType.getBikeDao();
            }
        }
        return null;
    }

    public BikeDAO bikeDAOByID(int id) {
        return bikeDaoByType(getBikeTypeByID(id));
    }

    public BikeDAO bikeDAOByCode(String code) {
        return bikeDaoByType(getBikeTypeByCode(code));
    }

    @SneakyThrows
    public int getBikeTypeByCode(String code) {
        int type = -1;
        ResultSet res = mySQL.query(SQLCommand.QUERY_BIKE_TYPE_BY_CODE, code);
        if (res.next()) {
            type = res.getInt("type");
        }
        return type;
    }

    @SneakyThrows
    public int getBikeTypeByID(int id) {
        int type = -1;
        ResultSet res = mySQL.query(SQLCommand.QUERY_BIKE_TYPE_BY_ID, id);
        if (res.next()) {
            type = res.getInt("type");
        }
        return type;
    }

    public enum BikeType {
        BICYCLE {
            @Override
            public int getInt() {
                return 0;
            }

            @Override
            protected BikeDAO getBikeDao() {
                return BikeDaoFactory.bicycleDAO;
            }

            public String toString() {
                return "Bicycle";
            }

        },
        TANDEM {
            @Override
            public int getInt() {
                return 1;
            }

            @Override
            protected BikeDAO getBikeDao() {
                return BikeDaoFactory.tandemDAO;
            }

            public String toString() {
                return "Tandem";
            }
        },
        E_BICYCLE {
            @Override
            public int getInt() {
                return 2;
            }

            @Override
            protected BikeDAO getBikeDao() {
                return BikeDaoFactory.electricBicycleDAO;
            }

            public String toString() {
                return "Electric Bicycle";
            }
        };
        public abstract int getInt();
        protected abstract BikeDAO getBikeDao();
    }
}
