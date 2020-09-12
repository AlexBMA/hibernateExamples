package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student_v13")
public class StudentV13 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<CourseV6> courses;

    public static class StudentV13Builder {

        private String firstName;
        private String lastName;
        private List<CourseV6> courses;

        public StudentV13Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentV13Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentV13Builder setCourses(List<CourseV6> courses) {
            this.courses = courses;
            return this;
        }

        public StudentV13 build() {
            return new StudentV13(firstName, lastName, courses);
        }
    }

    public StudentV13(String firstName, String lastName, List<CourseV6> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    public StudentV13() {


    }

    public List<CourseV6> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseV6> courses) {
        this.courses = courses;
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
}
