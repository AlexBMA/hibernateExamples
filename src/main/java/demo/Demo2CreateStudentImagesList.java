package demo;

import entity.Student;
import entity.StudentV2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Demo2CreateStudentImagesList {

    public static void main(String[] args) {
        //secondTest();
    }

    private static void secondTest() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentV2.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session currentSession = factory.getCurrentSession();
        try {


            StudentV2 s1 = new StudentV2.StudentV2Builder()
                    .setFirstNme("Alex")
                    .setLastName("Burghelea")
                    .setEmail("alex_burghelea@email.com")
                    .build();

            List<String> theImages = s1.getImages();
            theImages.add("AlexPhoto1.jpg");
            theImages.add("AlexPhoto2.jpg");
            theImages.add("AlexPhoto3.jpg");
            theImages.add("AlexPhoto4.jpg");

            s1.setImages(theImages);

            currentSession.beginTransaction();
            currentSession.persist(s1);

            currentSession.getTransaction().commit();
        } finally {

            currentSession.close();
            factory.close();
        }
    }
}
