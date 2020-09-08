package entity;

import javax.persistence.*;


@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class UserV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public static abstract class UserV2Builder {

        private String firstName;
        private String lastName;
        private String email;

        public UserV2Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserV2Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserV2Builder setEmail(String email) {
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

    public UserV2(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserV2() {
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
