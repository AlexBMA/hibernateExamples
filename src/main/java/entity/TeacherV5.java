package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher_v5")
public class TeacherV5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(fetch = FetchType.EAGER
            , mappedBy = "teacherV5"
            , cascade = {CascadeType.DETACH
            , CascadeType.MERGE
            , CascadeType.PERSIST
            , CascadeType.REFRESH})
    private List<CourseV2> courseV2List;

    public static class TeacherV5Builder {

        private String firstName;
        private String lastName;
        private List<CourseV2> courseV2List;


        public TeacherV5Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TeacherV5Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TeacherV5Builder setCourseV2List(List<CourseV2> courseV2List) {
            this.courseV2List = courseV2List;
            return this;
        }

        public TeacherV5 build() {
            return new TeacherV5(firstName, lastName, courseV2List);
        }
    }


    public TeacherV5(String firstName, String lastName, List<CourseV2> courseV2List) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseV2List = courseV2List;
    }

    public TeacherV5() {
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

    public List<CourseV2> getCourseV2List() {
        return courseV2List;
    }

    public void setCourseV2List(List<CourseV2> courseV2List) {
        this.courseV2List = courseV2List;
    }
}
