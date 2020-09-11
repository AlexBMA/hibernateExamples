package demo.object.mapping;

import entity.CourseV3;
import entity.TeacherV6;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo21OneToManyBidirectionalMappingLazyDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CourseV3.class)
                .addAnnotatedClass(TeacherV6.class)
                .buildSessionFactory();

        Session currentSession = addTeacherAnd2Courses(sessionFactory);
        currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        TeacherV6 teacherV6 = currentSession.get(TeacherV6.class, 9L);
        System.out.println(teacherV6.getFirstName());

        System.out.println(teacherV6.getCourses());

        String abc = "";


        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();
    }

    private static Session addTeacherAnd2Courses(SessionFactory sessionFactory) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        TeacherV6 tempTeacher = new TeacherV6
                .TeacherV6Builder()
                .setFirstName("Mark")
                .setLastName("Jones")
                .build();

        CourseV3 c1 = new CourseV3
                .CourseV3Builder()
                .setTitle("Neural Networks")
                .setTeacherV6(tempTeacher)
                .build();

        CourseV3 c2 = new CourseV3
                .CourseV3Builder()
                .setTitle("C#")
                .setTeacherV6(tempTeacher)
                .build();

        currentSession.save(tempTeacher);
        currentSession.save(c1);
        currentSession.save(c2);


        currentSession.getTransaction().commit();
        return currentSession;
    }
}
