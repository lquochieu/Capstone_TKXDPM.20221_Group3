package controller.dock;

import controller.BaseController;
import model.dao.DockDAO;


public class DockListController extends BaseController {

    DockDAO dockDAO = new DockDAO();

    public int getNumBike(int dockID) {
        return dockDAO.getNumBike(dockID);
    }
}
