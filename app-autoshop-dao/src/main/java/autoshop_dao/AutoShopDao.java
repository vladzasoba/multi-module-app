package autoshop_dao;

import entities.CarEntity;
import entities.CarToOrderEntity;
import entities.CustomerEntity;
import entities.OrderEntity;
import new_entities.Vehicle;

import java.util.List;

public interface AutoShopDao {
    List<Vehicle> getVehicles();
}
