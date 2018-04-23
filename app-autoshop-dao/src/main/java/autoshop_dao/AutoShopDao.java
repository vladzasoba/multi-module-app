package autoshop_dao;


import new_entities.Manufacturer;
import new_entities.Vehicle;

import java.util.List;

public interface AutoShopDao {
    List<Vehicle> getVehicles();
    List<Manufacturer> getManufacturers();
}
