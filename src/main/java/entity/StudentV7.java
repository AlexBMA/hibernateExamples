package entity;

import javax.persistence.*;

@Entity
@Table(name = "student_v7")
public class StudentV7 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    private AddressV2 homeAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "street",
                    column = @Column(name = "BILLING_STREET")),
            @AttributeOverride(name = "city",
                    column = @Column(name = "BILLING_CITY")),
            @AttributeOverride(name = "zipcode",
                    column = @Column(name = "BILLING_ZIP_CODE"))
    })
    private AddressV2 billingAddress;

    public static class StudentBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private AddressV2 homeAddress;
        private AddressV2 billingAddress;

        public StudentBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder setHomeAddress(AddressV2 homeAddress) {
            this.homeAddress = homeAddress;
            return this;
        }

        public StudentBuilder setBillingAddress(AddressV2 billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        public StudentV7 build() {
            return new StudentV7(firstName, lastName, email, homeAddress, billingAddress);
        }
    }


    public StudentV7() {
    }

    public StudentV7(String firstName, String lastName, String email, AddressV2 homeAddress, AddressV2 billingAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.homeAddress = homeAddress;
        this.billingAddress = billingAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressV2 getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(AddressV2 homeAddress) {
        this.homeAddress = homeAddress;
    }

    public AddressV2 getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressV2 billingAddress) {
        this.billingAddress = billingAddress;
    }
}
