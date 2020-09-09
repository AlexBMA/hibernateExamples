package demo.collections.mapping;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class Demo5CreateStudentImageSortedMaps {

    private static void addElementToDb(Session currentSession) {
        StudentV5 tempStudent = new StudentV5.StudentBuilder()
                .setFirstName("Eric")
                .setLastName("Stone")
                .setEmail("eric@luv2code.com")
                .build();


        SortedMap<String, String> imageMap = new TreeMap<>();
        imageMap.put("AlexPhoto1.jpg", "2 cats");
        imageMap.put("AlexPhoto2.jpg", "Dogs and cats");
        imageMap.put("AlexPhoto3.jpg", "A large house");
        imageMap.put("AlexPhoto4.jpg", "Shapes: triangle, square ");

        tempStudent.setImages(imageMap);

        currentSession.beginTransaction();
        currentSession.persist(tempStudent);
        currentSession.getTransaction().commit();
    }

    private static Session getElementFromDb(SessionFactory sessionFactory, long theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        StudentV5 student = currentSession.get(StudentV5.class, theId);
        System.out.println("Student details: " + student.toString());

        Map<String,String> images = student.getImages();
        images.forEach(((k,v)->{
            System.out.println(k);
            System.out.println(v);
        }));

        currentSession.getTransaction().commit();
        return currentSession;
    }

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentV5.class)
                .addAnnotatedClass(StudentV4.class)
                .addAnnotatedClass(StudentV3.class)
                .addAnnotatedClass(StudentV2.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        addElementToDb(currentSession);

        getElementFromDb(sessionFactory, 1);

        currentSession.close();
        sessionFactory.close();

    }
}
