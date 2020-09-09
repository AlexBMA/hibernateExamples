package demo.collections.mapping;

import entity.Student;
import entity.StudentV2;
import entity.StudentV3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.Map;

public class Demo3CreateStudentImageMap {

    public static void main(String[] args) {
        //thirdTest();
    }

    private static void thirdTest() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentV3.class)
                .addAnnotatedClass(StudentV2.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            StudentV3 s1 = new StudentV3.StudentV3Builder()
                    .setFirstName("Alex")
                    .setLastName("Burghelea")
                    .setEmail("alex_burghelea@email.com")
                    .build();

            Map<String, String> imageMap = new HashMap<>();
            imageMap.put("AlexPhoto1.jpg","A cat");
            imageMap.put("AlexPhoto2.jpg","A dog");
            imageMap.put("AlexPhoto3.jpg","A large house");
            imageMap.put("AlexPhoto4.jpg","A triangle");

            s1.setImages(imageMap);

            session.beginTransaction();
            session.persist(s1);
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
