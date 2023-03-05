import entity.Student;
import entity.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();

            // add data
//            Subject subject1 = new Subject();
//            subject1.setSubjectName("Toán cao cấp");
//            subject1.setCredit(2);
//            Subject subject2 = new Subject();
//            subject2.setSubjectName("Java core");
//            subject2.setCredit(4);
//            session.save(subject1);
//            session.save(subject2);

//            Subject subject3 = session.get(Subject.class,3);
//            Subject subject4 = session.get(Subject.class,4);

//            List<Subject> subjectList = new ArrayList<>();
//            subjectList.add(subject1);
//            subjectList.add(subject2);
//            subjectList.add(subject3);
//            subjectList.add(subject4);

//            Student student = new Student();
//            student.setFullName("Nguyễn Trung Quân");
//            student.setSubjects(subjectList);
//            session.save(student);

            // get data
//            Query<Student> selectStudent = session.createQuery("FROM Student");
//            List<Student> studentList = selectStudent.list();
//            for (Student studentArray : studentList){
//                System.out.println(studentArray);
//            }
//            Query<Subject> selectSubject = session.createQuery("FROM Subject");
//            List<Subject> SubjecttList = selectSubject.list();
//            for (Subject subjectArray : SubjecttList){
//                System.out.println(subjectArray);
//            }

            // update data
//            Subject subjectGetById = session.get(Subject.class,1);
//            Subject subjectUpdate = session.load(Subject.class,subjectGetById.getId());
//            subjectUpdate.setSubjectName("Ngữ văn 8");
//            subjectUpdate.setCredit(4);
//
//            Subject subjectGetById1 = session.get(Subject.class,3);
//            List<Subject> subjectList1 = new ArrayList<>();
//            subjectList1.add(subjectGetById);
//            subjectList1.add(subjectGetById1);
//
//            Student studentGetById = session.get(Student.class,1);
//            Student studentUpdate = session.load(Student.class,studentGetById.getId());
//            studentUpdate.setFullName("Trần Diệu Linh");
//            studentUpdate.setSubjects(subjectList1);

            // delete data
            Student studentGetById = session.get(Student.class,2);
            session.delete(studentGetById);


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
        configuration.addAnnotatedClass(Subject.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
