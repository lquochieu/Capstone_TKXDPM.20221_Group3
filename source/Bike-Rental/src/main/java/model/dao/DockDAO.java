package model.dao;


import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import model.dao.connection.MySQL;
import model.entity.dock.Dock;
import utils.SQLCommand;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Mysql Dock data access object implements {@link BaseDAO}
 *
 * @author Group 3
 */
@NoArgsConstructor
public class DockDAO implements BaseDAO<Dock> {
    List<Dock> docks = new ArrayList<>();
    MySQL mySQL = MySQL.getDriverConnection();

    @SneakyThrows
    private Dock extractDock(ResultSet res) {
        Dock dock = new Dock();
        try {
            dock.setId(res.getInt("id"));
            dock.setName(res.getNString("name"));
            dock.setAddress(res.getNString("address"));
            dock.setArea(res.getString("area"));
            dock.setStatus(res.getBoolean("status"));
            dock.setBikeAmount(res.getInt("bikeAmount"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dock;
    }

    private Dock checkId(int id) {
        if (docks.size() == 0) return null;
        for (Dock dock : docks) {
            if (dock.getId() == id) return dock;
        }
        return null;
    }

    @Override
    public List<Dock> getAll() {
        docks.clear();
        ResultSet res = mySQL.query(SQLCommand.QUERY_DOCK_LIST);
        try {
            while (res.next()) {
                docks.add(this.extractDock(res));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return docks;
    }

    @SneakyThrows
    @Override
    public Dock getByID(int id) {
        Dock dock = this.checkId(id);
        if (dock == null) {
            ResultSet res = mySQL.query(SQLCommand.QUERY_DOCK_BY_ID, id);
            if (res.next()) {
                dock = this.extractDock(res);
            }
        }
        return dock;
    }

    @Override
    public int save(Dock t) {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public void delete(Dock t) {
        // TODO Auto-generated method stub

    }

    @SneakyThrows
    public int getNumBike(int dockID) {
        ResultSet res = mySQL.query(SQLCommand.QUERY_NUM_ACTIVE_BIKE_BY_DOCK_ID, dockID);
        try {
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
}
