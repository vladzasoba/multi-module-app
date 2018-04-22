package autoshop_dao;


import entities.CarEntity;
import entities.CarToOrderEntity;
import entities.CustomerEntity;
import entities.OrderEntity;
import new_entities.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class AutoShopDaoImpl implements AutoShopDao {

    @Override
    public List<Vehicle> getVehicles() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("VehicleStorePersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();


        Query query = entityManager.createQuery("select v from Vehicle v");
        List resultList = query.getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

        return resultList;
    }
}
