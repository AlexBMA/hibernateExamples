package entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher_v4")
public class TeacherV4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "teacherV4"
            , cascade = {CascadeType.DETACH
            , CascadeType.MERGE
            , CascadeType.PERSIST
            , CascadeType.REFRESH})

    private List<Course> courses;

    public static class TeacherV4Builder {

        private String firstName;
        private String lastName;
        private String email;
        private List<Course> courses;

        public TeacherV4Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TeacherV4Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TeacherV4Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public TeacherV4Builder setCourses(List<Course> courses) {
            this.courses = courses;
            return this;
        }

        public TeacherV4 build() {
            return new TeacherV4(firstName, lastName, email, courses);
        }
    }

    public TeacherV4() {
    }

    public TeacherV4(String firstName, String lastName, String email, List<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.courses = courses;
    }

    public long getId() {
        return id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
