package entity;

import javax.persistence.Entity;

@Entity
public class StudentV10 extends UserV2 {

    private String course;


    public static class StudentV10Builder extends UserV2Builder {

        private String course;

        public StudentV10Builder setCourse(String course) {
            this.course = course;
            return this;
        }

        public StudentV10Builder setFirstName(String firstName) {
            super.setFirstName(firstName);
            return this;
        }

        public StudentV10Builder setLastName(String lastName) {
            super.setLastName(lastName);
            return this;
        }

        public StudentV10Builder setEmail(String email) {
            super.setEmail(email);
            return this;
        }

        public StudentV10 build() {
            return new StudentV10(super.getFirstName(), super.getLastName(), super.getEmail(), this.course);
        }
    }

    public StudentV10(String firstName, String lastName, String email, String course) {
        super(firstName, lastName, email);
        this.course = course;
    }

    public StudentV10() {
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
