package demo;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo12CreateStudentAndInstructorFromUserMappedSuperClassInheritance {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentV12.class)
                .addAnnotatedClass(InstructorV4.class)
                .buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        StudentV12 tempStudent = new StudentV12
                .StudentV12Builder()
                .setFirstName("John")
                .setLastName("Smith")
                .setEmail("j_smith@email.com")
                .setCourse("System design")
                .build();

        InstructorV4 tempInstructor = new InstructorV4
                .InstructorV4Builder()
                .setFirstName("Mike")
                .setLastName("Taylor")
                .setEmail("m_t@email.com")
                .setSalary(15000D)
                .build();

        currentSession.save(tempStudent);
        currentSession.save(tempInstructor);

        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();

    }
}
