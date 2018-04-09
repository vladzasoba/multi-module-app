package autoshop_dao;

import entities.*;

import java.util.List;

public interface AutoShopDao {
    Customer getCustomerById(long id);
    List<Customer> getAllCustomers();
    Car getCarById(long carId);
    List<Car> getCarsByManufacturer(Manufacturer manufacturer);
    List<Car> getCarsByModel(Model model);
    Order getOrderById(long id);
    List<Order> getOrdersByCustomer(Customer customer);
}
