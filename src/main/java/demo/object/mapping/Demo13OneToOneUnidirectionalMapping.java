package demo.object.mapping;

import entity.Teacher;
import entity.TeacherProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo13OneToOneUnidirectionalMapping {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(TeacherProfile.class)
                .buildSessionFactory();


        Session currentSession = sessionFactory.getCurrentSession();

        TeacherProfile teacherProfile = new TeacherProfile
                .TeacherProfileBuilder()
                .setHobby("boardgames")
                .setYoutubeChanel("youtube")
                .build();

        Teacher teacher = new Teacher
                .TeacherBuilder()
                .setTeacherProfile(teacherProfile)
                .setFirstName("Florian")
                .setLastName("Popescu")
                .setEmail("florian_popescu@email.com")
                .build();

        currentSession.beginTransaction();

        currentSession.save(teacher);

        currentSession.getTransaction().commit();
        currentSession.close();
        sessionFactory.close();

    }
}
