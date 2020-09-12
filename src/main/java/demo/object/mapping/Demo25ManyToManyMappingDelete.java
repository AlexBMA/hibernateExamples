package demo.object.mapping;

import entity.CourseV6;
import entity.StudentV13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class Demo25ManyToManyMappingDelete {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentV13.class)
                .addAnnotatedClass(CourseV6.class)
                .buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        CourseV6 c1 = new CourseV6
                .CourseV6Builder()
                .setCourseTitle("React master class")
                .build();

        CourseV6 c2 = new CourseV6
                .CourseV6Builder()
                .setCourseTitle("Java master class")
                .build();

        StudentV13 s1 = new StudentV13
                .StudentV13Builder()
                .setFirstName("John")
                .setLastName("Smith")
                .build();

        StudentV13 s2 = new StudentV13
                .StudentV13Builder()
                .setFirstName("Alan")
                .setLastName("Johnson")
                .build();

        List<StudentV13> listStudentC1 = new ArrayList<>();
        listStudentC1.add(s1);
        listStudentC1.add(s2);
        c1.setStudent(listStudentC1);

        List<StudentV13> listStudentC2 = new ArrayList<>();
        listStudentC2.add(s2);
        c2.setStudent(listStudentC2);

        currentSession.save(c1);
        currentSession.save(c2);
        currentSession.save(s1);
        currentSession.save(s2);

        currentSession.getTransaction().commit();

        currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();


        StudentV13 studentV13 = currentSession.get(StudentV13.class, 1l);

        currentSession.delete(studentV13);


        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();

    }
}
