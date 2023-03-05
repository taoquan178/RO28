package com.tn.repository;

import com.tn.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class PersonRepositoryBTVN {

    public void addPerson(String name, String password, String fullName, String email, int personType){
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

            // save dữ liệu
            Person person = new Person();
            person.setUsername(name);
            person.setPassword(password);
            person.setFullName(fullName);
            person.setEmail(email);
            if (personType == 1){
                person.setPersonType(Person.PersonType.EMPLOYEE);
            } else if (personType == 2){
                person.setPersonType(Person.PersonType.MANAGER);
            }else{
                System.err.println("Lỗi insert personType!");
            }
            session.save(person);
            System.out.println("Create success!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void getPersonById(int id){
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

            Person person = session.get(Person.class, id);
            System.out.println(person);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Person> getListPerson(){
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

            // get all dữ liệu
            // HQL : Hibernate query language
            Query<Person> query =  session.createQuery("FROM Person ");
            List<Person> person = query.list();
            System.out.println("Create success!");
            return person;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deletePersonById(int idPerson){
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

            session.beginTransaction(); // bắt đầu 1 Transaction
            Query<Person> query =  session.createQuery(" DELETE FROM Person WHERE id = :id");
            query.setParameter("id", idPerson);
            int num = query.executeUpdate(); // số bản ghi được thực thi
            session.getTransaction().commit(); // thực hiện
            System.out.println("Số bản ghi đã được cập nhập" + num);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updatePersonById(int idPerson,String newName, String newPassword, String newFullName, String newEmail, int newPersonType){
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

            session.beginTransaction(); // bắt đầu 1 Transaction
            Person person = session.load(Person.class,idPerson);
            //update
            person.setUsername(newName);
            person.setPassword(newPassword);
            person.setFullName(newFullName);
            person.setEmail(newEmail);
            if (newPersonType == 1){
                person.setPersonType(Person.PersonType.EMPLOYEE);
            } else if (newPersonType == 2){
                person.setPersonType(Person.PersonType.MANAGER);
            }else{
                System.err.println("Lỗi insert personType!");
            }
            session.getTransaction().commit(); // thực hiện
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
