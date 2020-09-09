package demo.collections.mapping;

import entity.Student;
import entity.StudentV2;
import entity.StudentV3;
import entity.StudentV4;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;


public class Demo4CreateStudentImageSortedSet {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentV4.class)
                .addAnnotatedClass(StudentV3.class)
                .addAnnotatedClass(StudentV2.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        addElementToDb(currentSession);

        currentSession = getElementFromDb(sessionFactory, 1);

        currentSession.close();
        sessionFactory.close();
    }

    private static Session getElementFromDb(SessionFactory sessionFactory, long theId) {
        Session currentSession;
        currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        StudentV4 student = currentSession.get(StudentV4.class, theId);
        System.out.println("Student details: " + student.toString());

        Set<String> images = student.getImages();
        images.forEach(System.out::println);

        currentSession.getTransaction().commit();
        return currentSession;
    }

    private static void addElementToDb(Session currentSession) {
        StudentV4 tempStudent = new StudentV4.StudentV4Builder()
                .setFirstName("Eric")
                .setLastName("Stone")
                .setEmail("eric@luv2code.com")
                .build();


        Set<String> theImages = tempStudent.getImages();
        theImages.add("photo100.jpg");
        theImages.add("photo20.jpg");
        theImages.add("photo30.jpg");
        theImages.add("photo40.jpg");
        theImages.add("photo50.jpg");

        currentSession.beginTransaction();
        currentSession.persist(tempStudent);
        currentSession.getTransaction().commit();
    }
}
