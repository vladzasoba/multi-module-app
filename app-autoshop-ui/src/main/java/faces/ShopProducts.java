package faces;

import auto_shop_service.AutoShopService;
import auto_shop_service.AutoShopServiceImple;
import autoshop_dao.AutoShopDao;
import autoshop_dao.AutoShopDaoImpl;
import entities.CarEntity;
import new_entities.Vehicle;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "productList")
public class ShopProducts {
    private AutoShopService autoShopService = new AutoShopServiceImple();

    public List<Vehicle> getVehicles() {
        return autoShopService.getVehicles();
    }
}
