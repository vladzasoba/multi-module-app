package new_entities;

import autoshop_dao.AutoShopDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPATTAT {
    public static void main(String[] args) {
        AutoShopDaoImpl autoShopDao = new AutoShopDaoImpl();
        List<Vehicle> vehicles = autoShopDao.getVehicles();

        System.out.println(vehicles);
    }
}
