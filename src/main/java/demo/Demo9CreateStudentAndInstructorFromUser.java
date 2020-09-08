package demo;

import entity.Instructor;
import entity.StudentV9;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo9CreateStudentAndInstructorFromUser {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(StudentV9.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        StudentV9 tempStudent = new StudentV9
                .StudentV9Builder()
                .setEmail("alex_test@email.com")
                .setLastName("Florescu")
                .setFirstName("Alex")
                .setCourse("Math")
                .build();

        Instructor instructor = new Instructor.InstructorBuilder()
                .setEmail("nicolae_iorga@email.com")
                .setLastName("Iorga")
                .setFirstName("Nicolae")
                .setSalary(2000D)
                .build();

        currentSession.beginTransaction();

        currentSession.save(tempStudent);
        currentSession.save(instructor);

        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();
    }
}
