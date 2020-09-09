package demo.object.mapping;

import entity.TeacherProfileV3;
import entity.TeacherV3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo17OneToOneBidirectionalMappingDeleteOnlyInstructorDetail {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(TeacherProfileV3.class)
                .addAnnotatedClass(TeacherV3.class)
                .buildSessionFactory();

        addItemToDb(sessionFactory);

    }

    private static void addItemToDb(SessionFactory sessionFactory) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        TeacherProfileV3 teacherProfileV3 = new TeacherProfileV3
                .TeacherProfileV3Builder()
                .setHobby("basketball")
                .setYoutubeChanel("nbaNonStop")
                .build();

        TeacherV3 teacherV3 = new TeacherV3
                .TeacherV3Builder()
                .setFirstName("Martin")
                .setLastName("Jones")
                .setTeacherProfileV3(teacherProfileV3)
                .setEmail("m_j@email.com")
                .build();

        currentSession.save(teacherV3);
        currentSession.getTransaction().commit();

        currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();
        TeacherProfileV3 temp = currentSession.get(TeacherProfileV3.class, 1L);
        //remove the bidirectional link
        temp.getTeacherV3().setTeacherProfileV3(null);
        currentSession.delete(temp);
        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();
    }
}
