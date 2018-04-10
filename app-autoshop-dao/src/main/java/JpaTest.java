import entities.Customer;

import javax.persistence.*;
import java.util.List;

public class JpaTest {
    public static void main(String[] args) {
        EntityManagerFactory autoShopPersistenceUnit = Persistence.createEntityManagerFactory("AutoShopPersistenceUnit");
        EntityManager entityManager = autoShopPersistenceUnit.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("select c from Customer c");
        List resultList = query.getResultList();
        Customer customer = (Customer) resultList.get(0);

        transaction.commit();
        entityManager.close();
        autoShopPersistenceUnit.close();

        System.out.println(customer);
    }
}
