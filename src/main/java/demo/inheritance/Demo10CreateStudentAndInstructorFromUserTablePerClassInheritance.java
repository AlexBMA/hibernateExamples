package demo.inheritance;

import entity.InstructorV2;
import entity.StudentV10;
import entity.UserV2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo10CreateStudentAndInstructorFromUserTablePerClassInheritance {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserV2.class)
                .addAnnotatedClass(InstructorV2.class)
                .addAnnotatedClass(StudentV10.class)
                .buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        StudentV10 tempStudent = new StudentV10
                .StudentV10Builder()
                .setFirstName("John")
                .setLastName("Smith")
                .setEmail("j_smith@email.com")
                .setCourse("System design")
                .build();

        InstructorV2 tempInstructor = new InstructorV2
                .InstructorV2Builder()
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
