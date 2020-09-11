package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher_v6")
public class TeacherV6 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY
            , mappedBy = "teacherV6"
            , cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<CourseV3> courses;

    public static class TeacherV6Builder {

        private String firstName;
        private String lastName;
        private List<CourseV3> courses;

        public TeacherV6Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TeacherV6Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TeacherV6Builder setCourses(List<CourseV3> courses) {
            this.courses = courses;
            return this;
        }

        public TeacherV6 build() {
            return new TeacherV6(firstName, lastName, courses);
        }
    }

    public TeacherV6(String firstName, String lastName, List<CourseV3> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    public TeacherV6() {
    }

    public List<CourseV3> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseV3> courses) {
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
