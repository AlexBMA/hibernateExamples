package demo.object.mapping;

import entity.Course;
import entity.TeacherV4;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Demo19OneToManyBidirectionalMappingDelete {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(TeacherV4.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        addTeacherAndCourses(sessionFactory);

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        TeacherV4 teacherV4 = currentSession.get(TeacherV4.class, 1L);

        Course course = teacherV4.getCourses().get(1);
        currentSession.delete(course);

        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();

    }

    private static Session addTeacherAndCourses(SessionFactory sessionFactory) {
        TeacherV4 teacherV4 = new TeacherV4
                .TeacherV4Builder()
                .setFirstName("Max")
                .setLastName("Johnson")
                .setEmail("max_johnson@email.com")
                .build();

        Course c1 = new Course.CourseBuilder()
                .setTitle("Math")
                .setTeacherV4(teacherV4)
                .build();

        Course c2 = new Course.CourseBuilder()
                .setTitle("System design")
                .setTeacherV4(teacherV4)
                .build();

        Course c3 = new Course.CourseBuilder()
                .setTitle("Robotics")
                .setTeacherV4(teacherV4)
                .build();

        List<Course> courseList = new ArrayList<>();
        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);

        teacherV4.setCourses(courseList);

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.save(teacherV4);
        currentSession.save(c1);
        currentSession.save(c2);
        currentSession.save(c3);
        currentSession.getTransaction().commit();
        return currentSession;
    }
}
