package com.tn;

import com.tn.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Program {

    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

            // save dữ liệu
//            Person person = new Person();
//            person.setUsername("Quân1");
//            person.setPassword("1234Quan1");
//            person.setFullName("Nguyễn Trung Quân1");
//            person.setEmail("taoquan179@gmail.com");
//            session.save(person);

            // get all dữ liệu
            // HQL : Hibernate query language
//            Query<Person> query =  session.createQuery("FROM Person");
//            List<Person> person = query.list();
//            for (Person personArray : person) {
//                System.out.println(personArray);
//            }

            // get dữ liệu by id
            // cách 1
//            Person person = session.get(Person.class, 1);
//            System.out.println(person);

            // cách 2
//            Query<Person> query =  session.createQuery("FROM Person WHERE id = 1");
//            List<Person> person = query.list();
//            for (Person personArray : person) {
//                System.out.println(personArray);
//            }

            // cách khác của cách 2  dùng cách này để lấy giá trị duy nhất, kiểu giá trị unique không
//            Query<Person> query =  session.createQuery("FROM Person WHERE id = 1");
//            Person person = query.uniqueResult();
//            System.out.println(person);

            // update dữ liệu
            // update using hql
            // đang fix cứng
//            session.beginTransaction(); // bắt đầu 1 Transaction
//            Query<Person> query =  session.createQuery("UPDATE Person SET username = 'Quân11' WHERE id = 2");
//            int num = query.executeUpdate(); // số bản ghi được thực thi
//            session.getTransaction().commit(); // thực hiện
//            System.out.println("Số bản ghi đã được cập nhập" + num);

            // không fix cứng nữa
//            session.beginTransaction(); // bắt đầu 1 Transaction
//            Query<Person> query =  session.createQuery("UPDATE Person SET username = :username WHERE id = :id");
//            query.setParameter("username", "Quân11");
//            query.setParameter("id", 3);
//            int num = query.executeUpdate(); // số bản ghi được thực thi
//            session.getTransaction().commit(); // thực hiện
//            System.out.println("Số bản ghi đã được cập nhập" + num);


            // delete dữ liệu
//            int idPerson = 4;
//            session.beginTransaction(); // bắt đầu 1 Transaction
//            Query<Person> query =  session.createQuery(" DELETE FROM Person WHERE id = :id");
//            query.setParameter("id", idPerson);
//            int num = query.executeUpdate(); // số bản ghi được thực thi
//            session.getTransaction().commit(); // thực hiện
//            System.out.println("Số bản ghi đã được cập nhập" + num);


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
        configuration.addAnnotatedClass(Person.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

}
