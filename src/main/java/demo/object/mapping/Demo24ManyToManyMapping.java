package demo.object.mapping;

import entity.CourseV6;
import entity.StudentV13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Demo24ManyToManyMapping {

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


        StudentV13 s1 = new StudentV13
                .StudentV13Builder()
                .setFirstName("John")
                .setLastName("Smith")
                .build();

        List<StudentV13> listStudent = new ArrayList<>();
        listStudent.add(s1);
        c1.setStudent(listStudent);

        currentSession.save(c1);
        currentSession.save(s1);

        currentSession.getTransaction().commit();
        currentSession.close();
        sessionFactory.close();

    }
}
