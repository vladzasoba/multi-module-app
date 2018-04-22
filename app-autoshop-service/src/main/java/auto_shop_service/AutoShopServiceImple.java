package auto_shop_service;

import autoshop_dao.AutoShopDao;
import autoshop_dao.AutoShopDaoImpl;
import new_entities.Vehicle;

import java.util.List;

public class AutoShopServiceImple implements AutoShopService {
    public AutoShopDao dao = new AutoShopDaoImpl();

    public List<Vehicle> getVehicles() {
        return dao.getVehicles();
    }
}
