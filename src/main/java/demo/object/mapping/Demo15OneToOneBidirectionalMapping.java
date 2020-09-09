package demo.object.mapping;

import entity.TeacherProfileV2;
import entity.TeacherV2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo15OneToOneBidirectionalMapping {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(TeacherV2.class)
                .addAnnotatedClass(TeacherProfileV2.class)
                .buildSessionFactory();


        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        TeacherProfileV2 teacherProfileV2 = new TeacherProfileV2
                .TeacherProfileV2Builder()
                .setHobby("cooking")
                .setYoutubeChanel("foodtime")
                .build();

        TeacherV2 teacherV2 = new TeacherV2
                .TeacherV2Builder()
                .setFirstName("John")
                .setLastName("Roberts")
                .setTeacherProfileV2(teacherProfileV2)
                .setEmail("j_r@email.com")
                .build();

        currentSession.save(teacherV2);
        currentSession.getTransaction().commit();

        currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();
        TeacherProfileV2 temp = currentSession.get(TeacherProfileV2.class, 1L);

        if (temp != null) {
            TeacherV2 tempTeacher = temp.getTeacherV2();
            System.out.println(tempTeacher.getFirstName());
            System.out.println(tempTeacher.getLastName());
            System.out.println(tempTeacher.getEmail());
        }


        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();

    }
}
