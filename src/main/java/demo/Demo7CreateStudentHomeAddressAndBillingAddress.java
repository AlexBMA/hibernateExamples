package demo;

import entity.AddressV2;
import entity.StudentV7;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo7CreateStudentHomeAddressAndBillingAddress {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentV7.class)
                .addAnnotatedClass(AddressV2.class)
                .buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        AddressV2 homeAddress = new AddressV2.AddressV2Builder()
                .setCity("Iasi")
                .setStreet("Palat")
                .setZipcode("700123")
                .build();

        AddressV2 billingAddress = new AddressV2.AddressV2Builder()
                .setZipcode("123456")
                .setStreet("Lapusneanu")
                .setCity("Iasi")
                .build();

        StudentV7 studentV7 = new StudentV7.StudentBuilder()
                .setLastName("Popescu")
                .setFirstName("alex")
                .setEmail("alex_new@email.com")
                .setHomeAddress(homeAddress)
                .setBillingAddress(billingAddress)
                .build();

        currentSession.persist(studentV7);

        currentSession.getTransaction().commit();

        currentSession.close();
        sessionFactory.close();
    }
}
