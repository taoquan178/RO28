package com.tn;

import com.tn.entity.Address;
import com.tn.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Program {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();

            // thêm dữ liệu
//            Student student = new Student();
//            student.setStudentName("Song");
//            student.setAge(21);
//            session.save(student);
//
            // thêm address
//            Address address = new Address();
//            address.setStreet("TT");

//            Student student1 = session.get(Student.class,1);
//            address.setStudent(student1);
            // cách khác
//            address.setStudent(student);

            // lưu data
//            session.save(address);

            // update address
//            Student student3 = session.get(Student.class,3);
//            Address address4 = session.get(Address.class,4);
//            address4.setStudent(student3);

            Address address4 = session.get(Address.class,4);
//            System.out.println(address4);
            System.out.println(address4.getStreet());
            System.out.println(address4.getStudent().getStudentName());

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
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Address.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
