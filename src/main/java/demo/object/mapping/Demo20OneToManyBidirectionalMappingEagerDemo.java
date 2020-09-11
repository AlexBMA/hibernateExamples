package demo.object.mapping;

import entity.CourseV2;
import entity.TeacherV5;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Demo20OneToManyBidirectionalMappingEagerDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(TeacherV5.class)
                .addAnnotatedClass(CourseV2.class)
                .buildSessionFactory();

        Session currentSession = addTeacherAnd2Courses(sessionFactory);

        currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();
        TeacherV5 teacherV5 = currentSession.get(TeacherV5.class, 1L);
        List<CourseV2> courseV2List = teacherV5.getCourseV2List();

        courseV2List.forEach(item -> System.out.println(item.getTitle()));
        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();
    }

    private static Session addTeacherAnd2Courses(SessionFactory sessionFactory) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        TeacherV5 teacherV5 = new TeacherV5
                .TeacherV5Builder()
                .setFirstName("Victor")
                .setLastName("Smith")
                .build();

        CourseV2 c1 = new CourseV2
                .CourseV2Builder()
                .setTitle("Math 1")
                .setTeacherV5(teacherV5)
                .build();

        CourseV2 c2 = new CourseV2
                .CourseV2Builder()
                .setTitle("System design")
                .setTeacherV5(teacherV5)
                .build();

        currentSession.save(teacherV5);
        currentSession.save(c1);
        currentSession.save(c2);

        currentSession.getTransaction().commit();
        return currentSession;
    }

}
