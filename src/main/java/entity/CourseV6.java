package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course_v6")
public class CourseV6 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "course_title")
    private String courseTitle;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentV13> student;


    public static class CourseV6Builder {
        private String courseTitle;
        private List<StudentV13> student;


        public CourseV6Builder setCourseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
            return this;
        }

        public CourseV6Builder setStudent(List<StudentV13> student) {
            this.student = student;
            return this;
        }

        public CourseV6 build() {
            return new CourseV6(courseTitle, student);
        }

    }

    public CourseV6(String courseTitle, List<StudentV13> student) {
        this.courseTitle = courseTitle;
        this.student = student;
    }

    public CourseV6() {
    }

    public List<StudentV13> getStudent() {
        return student;
    }

    public void setStudent(List<StudentV13> student) {
        this.student = student;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
}
