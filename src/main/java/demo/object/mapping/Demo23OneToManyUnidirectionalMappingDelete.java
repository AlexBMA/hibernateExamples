package demo.object.mapping;

import entity.CourseV5;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Demo23OneToManyUnidirectionalMappingDelete {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CourseV5.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Review r1 = new Review
                .ReviewBuilder()
                .setReviewText("Very good, all content is wonderful")
                .build();

        Review r2 = new Review
                .ReviewBuilder()
                .setReviewText("5 star course")
                .build();

        List<Review> reviews = new ArrayList<>();
        reviews.add(r1);
        reviews.add(r2);

        CourseV5 c1 = new CourseV5
                .CourseV5Builder()
                .setReview(reviews)
                .setTitle("React master class")
                .build();

        currentSession.save(c1);

        currentSession.getTransaction().commit();

        currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        CourseV5 courseV5 = currentSession.get(CourseV5.class, 1L);

        if (courseV5 != null) currentSession.delete(courseV5);

        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();

    }
}
