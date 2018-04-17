package autoshop_dao;

import entities.CarEntity;
import entities.CarToOrderEntity;
import entities.CustomerEntity;
import entities.OrderEntity;

import java.util.List;

public interface AutoShopDao {
    CustomerEntity getCustomerById(int customerId);
    CarEntity getCarById(int carId);
    List<CarEntity> getAllCarEntities();
}
