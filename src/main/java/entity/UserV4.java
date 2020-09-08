package entity;

import javax.persistence.*;


@MappedSuperclass
public abstract class UserV4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public static abstract class UserV4Builder {

        private String firstName;
        private String lastName;
        private String email;

        public UserV4Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserV4Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserV4Builder setEmail(String email) {
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

    public UserV4(String firstName, String lastName, String email) {
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
