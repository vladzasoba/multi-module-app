package autoshop_dao;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AutoShopDaoImpl implements AutoShopDao {
    public Customer getCustomerById(long id) {
        EntityManagerFactory autoShopPersistenceUnit = Persistence.createEntityManagerFactory("AutoShopPersistenceUnit");
        EntityManager entityManager = autoShopPersistenceUnit.createEntityManager();

        Customer customer = entityManager.find(Customer.class, id);
        entityManager.close();
        autoShopPersistenceUnit.close();
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return null;
    }

    public Car getCarById(long carId) {
        return null;
    }

    public List<Car> getCarsByManufacturer(Manufacturer manufacturer) {
        return null;
    }

    public List<Car> getCarsByModel(Model model) {
        return null;
    }

    public Order getOrderById(long id) {
        return null;
    }

    public List<Order> getOrdersByCustomer(Customer customer) {
        return null;
    }
}
