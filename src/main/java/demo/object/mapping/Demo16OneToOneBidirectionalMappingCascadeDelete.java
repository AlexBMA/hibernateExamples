package demo.object.mapping;

import entity.TeacherProfileV2;
import entity.TeacherV2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo16OneToOneBidirectionalMappingCascadeDelete {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(TeacherV2.class)
                .addAnnotatedClass(TeacherProfileV2.class)
                .buildSessionFactory();

        addItemToDb(sessionFactory);

        sessionFactory.close();
    }

    private static void addItemToDb(SessionFactory sessionFactory) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        TeacherProfileV2 teacherProfileV2 = new TeacherProfileV2
                .TeacherProfileV2Builder()
                .setHobby("basketball")
                .setYoutubeChanel("nbaNonStop")
                .build();

        TeacherV2 teacherV2 = new TeacherV2
                .TeacherV2Builder()
                .setFirstName("Martin")
                .setLastName("Jones")
                .setTeacherProfileV2(teacherProfileV2)
                .setEmail("m_j@email.com")
                .build();

        currentSession.save(teacherV2);
        currentSession.getTransaction().commit();

        currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();
        TeacherProfileV2 temp = currentSession.get(TeacherProfileV2.class, 1L);
        currentSession.delete(temp);
        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();
    }
}
