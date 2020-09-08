package demo;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo11CreateStudentAndInstructorFromUserJoinTableInheritance {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserV3.class)
                .addAnnotatedClass(StudentV11.class)
                .addAnnotatedClass(InstructorV3.class)
                .buildSessionFactory();


        StudentV11 tempStudent = new StudentV11
                .StudentV11Builder()
                .setFirstName("John")
                .setLastName("Smith")
                .setEmail("j_smith@email.com")
                .setCourse("System design")
                .build();

        InstructorV3 tempInstructor = new InstructorV3
                .InstructorV3Builder()
                .setFirstName("Mike")
                .setLastName("Taylor")
                .setEmail("m_t@email.com")
                .setSalary(15000D)
                .build();


        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        currentSession.save(tempStudent);
        currentSession.save(tempInstructor);

        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();
    }
}
