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
        EntityManagerFactory shopPersistenceUnit = Persistence.createEntityManagerFactory("AutoShopPersistenceUnit");
        EntityManager entityManager = shopPersistenceUnit.createEntityManager();

        CustomerEntity customerEntity = entityManager.find(CustomerEntity.class, customerId);

        entityManager.close();
        shopPersistenceUnit.close();

        return  customerEntity;
    }

    @Override
    public CarEntity getCarById(int carId) {
        EntityManagerFactory shopPersistenceUnit = Persistence.createEntityManagerFactory("AutoShopPersistenceUnit");
        EntityManager entityManager = shopPersistenceUnit.createEntityManager();

        CarEntity carEntity = entityManager.find(CarEntity.class, carId);

        entityManager.close();
        shopPersistenceUnit.close();

        return  carEntity;
    }

    @Override
    public List<OrderEntity> getOrdersByCustomer(CustomerEntity customer) {
        return (List) customer.getOrdersByCustomerId();
    }

    //TODO
    @Override
    public List<CarToOrderEntity> getCarsToOrder(OrderEntity order) {
        return null;
    }

    @Override
    public List<CarEntity> getOrderedCarsByCustomer(CustomerEntity customer) {
        List<OrderEntity> ordersByCustomer = getOrdersByCustomer(customer);
        List<CarToOrderEntity> carToOrders = new LinkedList<>();

        for (OrderEntity orderEntity: ordersByCustomer) {
            List<CarToOrderEntity> carsToOrder = getCarsToOrder(orderEntity);
            carToOrders.addAll(carsToOrder);
        }

        List<CarEntity> cars = new LinkedList<>();

        for (CarToOrderEntity carToOrder: carToOrders) {
            cars.add(carToOrder.getCarByCarId());
        }

        return cars;
    }
}
