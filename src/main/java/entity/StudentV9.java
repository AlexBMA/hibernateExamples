package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "STUDENT")
public class StudentV9 extends User {

    private String course;

    public static class StudentV9Builder extends UserBuilder {

        private String course;

        public StudentV9Builder setCourse(String course) {
            this.course = course;
            return this;
        }

        public StudentV9Builder setFirstName(String firstName) {
            super.setFirstName(firstName);
            return this;
        }

        public StudentV9Builder setLastName(String lastName) {
            super.setLastName(lastName);
            return this;
        }

        public StudentV9Builder setEmail(String email) {
            super.setEmail(email);
            return this;
        }


        public StudentV9 build() {
            return new StudentV9(super.getFirstName(), super.getLastName(), super.getEmail(), course);
        }


    }


    public StudentV9() {

    }

    public StudentV9(String firstName, String lastName, String email, String course) {
        super(firstName, lastName, email);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
