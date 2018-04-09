package custom_service;

import autoshop_dao.AutoShopDao;
import entities.Customer;

public class AutoShopService {
    private AutoShopDao autoShopDao;

    public Customer getCustomer(long id) {
        return autoShopDao.getCustomerById(id);
    }
}
