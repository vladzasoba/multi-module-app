package autoshop_dao;


import entities.CarEntity;
import entities.CarToOrderEntity;
import entities.CustomerEntity;
import entities.OrderEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class AutoShopDaoImpl implements AutoShopDao {

    @Override
    public CustomerEntity getCustomerById(int customerId) {
        return null;
    }

    @Override
    public CarEntity getCarById(int carId) {
        return null;
    }

    @Override
    public List<CarEntity> getAllCarEntities() {
        return null;
    }
}
