package demo.object.mapping;

import entity.Teacher;
import entity.TeacherProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo14OneToOneUnidirectionalMappingDelete {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(TeacherProfile.class)
                .addAnnotatedClass(Teacher.class)
                .buildSessionFactory();


        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Teacher teacher = currentSession.get(Teacher.class, 1L);
        if (teacher != null) currentSession.delete(teacher);


        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();

    }
}
