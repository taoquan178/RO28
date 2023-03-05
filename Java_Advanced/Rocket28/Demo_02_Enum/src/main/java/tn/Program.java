package tn;

import tn.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import tn.entity.Person;

public class Program {

    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

            // thêm dữ liệu
            Person person = new Person();
            person.setUsername("Quân3");
            person.setPassword("1234Quan3");
            person.setFullName("Nguyễn Trung Quân3");
            person.setEmail("taoquan179@gmail.com");
            person.setPersonType(Person.PersonType.EMPLOYEE);
            session.save(person);



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
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Person.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

}
