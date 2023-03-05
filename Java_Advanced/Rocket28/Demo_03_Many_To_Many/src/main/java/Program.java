
import entity.Address;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();

            // thêm dữ liệu many to many
            Address address1 = new Address();
            address1.setStreet("HN");
            session.save(address1);

            Address address2 = new Address();
            address2.setStreet("HCM");
            session.save(address2);

            User user1 = new User();
            user1.setUsername("quan");
            user1.setFullName("Trung Quan");

            List<Address> addressesList = new ArrayList<>();
            addressesList.add(address1);
            addressesList.add(address2);

            user1.setAddress(addressesList);
            session.save(user1);
            // end many to many


            session.getTransaction().commit();
            System.out.println("Create success!");

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private static SessionFactory buildSessionFactory() {
        // load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Address.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
