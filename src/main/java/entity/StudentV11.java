package entity;

import javax.persistence.Entity;

@Entity
public class StudentV11 extends UserV3 {

    private String course;

    public static class StudentV11Builder extends UserV3Builder {
        private String course;

        public StudentV11Builder setFirstName(String firstName) {
            super.setFirstName(firstName);
            return this;
        }

        public StudentV11Builder setLastName(String lastName) {
            super.setLastName(lastName);
            return this;
        }

        public StudentV11Builder setEmail(String email) {
            super.setEmail(email);
            return this;
        }

        public StudentV11Builder setCourse(String course) {
            this.course = course;
            return this;
        }

        public StudentV11 build() {
            return new StudentV11(super.getFirstName(), super.getLastName(), super.getEmail(), course);
        }
    }

    public StudentV11(String firstName, String lastName, String email, String course) {
        super(firstName, lastName, email);
        this.course = course;
    }

    public StudentV11() {
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
