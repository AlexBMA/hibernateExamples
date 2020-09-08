package demo;

import entity.StudentV8;
import enums.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo8CreateStudentWithStatusEnum {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentV8.class)
                .buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        StudentV8 tempStudent = new StudentV8.StudentBuilder()
                .setEmail("hugo_new_email@email.com")
                .setStatus(Status.ACTIVE)
                .setLastName("Hugo")
                .setFirstName("Victor")
                .build();

        StudentV8 tempStudent2 = new StudentV8.StudentBuilder()
                .setEmail("mario_new_email@email.com")
                .setStatus(Status.ACTIVE)
                .setLastName("Mario")
                .setFirstName("Nintendo")
                .build();

        currentSession.persist(tempStudent);
        currentSession.persist(tempStudent2);
        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();
    }
}
