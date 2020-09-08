package entity;

import javax.persistence.*;

@Entity
@Table(name = "user_v3")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserV3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public static abstract class UserV3Builder {

        private String firstName;
        private String lastName;
        private String email;

        public UserV3Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserV3Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserV3Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }
    }

    public UserV3() {
    }

    public UserV3(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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
}
