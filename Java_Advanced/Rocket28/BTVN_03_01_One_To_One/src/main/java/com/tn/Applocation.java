package com.tn;

import com.tn.entity.Department;
import com.tn.entity.Director;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Applocation {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();

            // add data
//            Director director = new Director();
//            director.setName("Quân");
//            director.setFullName("Nguyễn Trung Quân");
//            session.save(director);
//
//            Department department = new Department();
//            department.setName("Marketing");
//            department.setDirector(director);
//            session.save(department);

            // get data
//            Query<Department> querySelect = session.createQuery("FROM Department");
//            List<Department> departmentList = querySelect.list();
//            for (Department departmentArr : departmentList) {
//                System.out.println(departmentArr.getId());
//                System.out.println(departmentArr.getName());
//                System.out.println(departmentArr.getDirector().getId());
//            }
//            Query<Director> querySelect1 = session.createQuery("FROM Director");
//            List<Director> directorList = querySelect1.list();
//            for(Director directorArr : directorList){
//                System.out.println(directorArr.getId());
//                System.out.println(directorArr.getName());
//                System.out.println(directorArr.getFullName());
//            }


            // delete data
//            Director directorGetById = session.get(Director.class, 2);
//            Query<Department> querySelect = session.createQuery("FROM Department WHERE director = :director");
//            querySelect.setParameter("director",directorGetById);
//            List<Department> departmentList = querySelect.list();
//            Department departmentDelete = session.get(Department.class,departmentList.get(0).getId());
//            session.delete(departmentDelete);
//            session.delete(directorGetById);

            // update data
//            Director directorGetById = session.get(Director.class, 1);
//            Query<Department> querySelect = session.createQuery("FROM Department WHERE director = :director");
//            querySelect.setParameter("director",directorGetById);
//            List<Department> departmentList = querySelect.list();
//
//            Department departmentUpdate = session.load(Department.class,departmentList.get(0).getId());
//            Director directorUpdate = session.load(Director.class,directorGetById.getId());
//            departmentUpdate.setName("Sale");
//            directorUpdate.setName("Nam");
//            directorUpdate.setFullName("Nguyễn Trung Nam");


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
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Director.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
