package faces;

import autoshop_dao.AutoShopDao;
import autoshop_dao.AutoShopDaoImpl;
import entities.CarEntity;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "productList")
public class ShopProducts {
    private AutoShopDao autoShopDao = new AutoShopDaoImpl();

    public CarEntity getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(CarEntity selectedCar) {
        this.selectedCar = selectedCar;
    }

    private CarEntity selectedCar;

    public List<CarEntity> getCars() {
        return autoShopDao.getAllCarEntities();
    }
}
