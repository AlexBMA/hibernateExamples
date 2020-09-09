package demo.collections.mapping;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class Demo1CreateStudentImagesSet {

    public static void main(String[] args) {
        //firstTest();

    }

    private static void firstTest() {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();


        try {
            //create the object
            Student tempStudent = new Student.StudentBuilder()
                    .setFirstName("Eric")
                    .setLastName("Smith")
                    .setEmail("eric@luv2code.com")
                    .build();


            Set<String> theImages = tempStudent.getImages();
            theImages.add("photo10.jpg");
            theImages.add("photo20.jpg");
            theImages.add("photo30.jpg");
            theImages.add("photo40.jpg");
            theImages.add("photo50.jpg");


            //start a transaction
            session.beginTransaction();
            //save the object
            System.out.println("saving the student and images");
            session.persist(tempStudent);


            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!");


        } finally {
            //clean up code
            session.close();
            factory.close();
        }
    }
}
