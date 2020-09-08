package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student_12")
public class StudentV12 extends UserV4 {

    @Column(name = "course")
    private String course;

    public static class StudentV12Builder extends UserV4Builder {
        private String course;

        public StudentV12Builder setFirstName(String firstName) {
            super.setFirstName(firstName);
            return this;
        }

        public StudentV12Builder setLastName(String lastName) {
            super.setLastName(lastName);
            return this;
        }

        public StudentV12Builder setEmail(String email) {
            super.setEmail(email);
            return this;
        }

        public StudentV12Builder setCourse(String course) {
            this.course = course;
            return this;
        }

        public StudentV12 build() {
            return new StudentV12(super.getFirstName(), super.getLastName(), super.getEmail(), course);
        }
    }


    public StudentV12(String firstName, String lastName, String email, String course) {
        super(firstName, lastName, email);
        this.course = course;
    }

    public StudentV12(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
