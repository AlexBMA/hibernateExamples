package demo;

import entity.Address;
import entity.StudentV6;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo6CreateStudentAddress {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentV6.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        Session currentSession = addNewStudent(sessionFactory);

        currentSession.close();
        sessionFactory.close();
    }

    private static Session addNewStudent(SessionFactory sessionFactory) {
        Session currentSession = sessionFactory.getCurrentSession();


        Address homeAddress = new Address.AddressBuilder()
                .setCity("Iasi")
                .setStreet("Muntenimii")
                .setZipcode("700539")
                .build();

        StudentV6 student = new StudentV6.StudentBuilder()
                .setLastName("Florescu")
                .setFirstName("Alex")
                .setEmail("alex@email.com")
                .setAddress(homeAddress)
                .build();


        currentSession.beginTransaction();
        currentSession.persist(student);
        currentSession.getTransaction().commit();
        return currentSession;
    }


}
