package test_entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class JPATest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("META-INF/hibernate-h2.cfg.xml");

        configuration.addResource("mappingClass.xml");

        SchemaExport schemaExport = new SchemaExport();

        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();

        //session.beginTransaction();
        Customer customer = new Customer();
        customer.setFirstName("Ivan");
        customer.setLastName("Ivanchenko");
        customer.setCity("Odessa");
        customer.setCountry("Ukraine");
        customer.setPhonenNumber("+380995551214");
        session.beginTransaction();
        //session.save(customer);
        session.persist(customer);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
