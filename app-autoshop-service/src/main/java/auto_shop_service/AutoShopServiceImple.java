package auto_shop_service;

import autoshop_dao.AutoShopDao;
import autoshop_dao.AutoShopDaoImpl;
import new_entities.Manufacturer;
import new_entities.Vehicle;

import java.util.Arrays;
import java.util.List;

public class AutoShopServiceImple implements AutoShopService {
    public AutoShopDao dao = new AutoShopDaoImpl();

    public List<Vehicle> getVehicles() {
        return dao.getVehicles();
    }

    public List<Manufacturer> getManufacturers() {
        return dao.getManufacturers();
    }

    public List<String> getColors() {
        String[] colors = new String[10];
        colors[0] = "Black";
        colors[1] = "White";
        colors[2] = "Green";
        colors[3] = "Red";
        colors[4] = "Blue";
        colors[5] = "Orange";
        colors[6] = "Silver";
        colors[7] = "Yellow";
        colors[8] = "Brown";
        colors[9] = "Maroon";
        return Arrays.asList(colors);
    }


}
