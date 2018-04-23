package auto_shop_service;

import com.sun.naming.internal.VersionHelper;
import new_entities.Manufacturer;
import new_entities.Vehicle;

import java.util.List;

public interface AutoShopService {
    List<Vehicle> getVehicles();
    List<Manufacturer> getManufacturers();

    List<String> getColors();
}
