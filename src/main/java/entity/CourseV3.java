package entity;


import javax.persistence.*;

@Entity
@Table(name = "course_v3")
public class CourseV3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "teacher_v6_id")
    private TeacherV6 teacherV6;

    public static class CourseV3Builder{

        private String title;
        private TeacherV6 teacherV6;

        public CourseV3Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public CourseV3Builder setTeacherV6(TeacherV6 teacherV6) {
            this.teacherV6 = teacherV6;
            return this;
        }

        public CourseV3 build(){
            return new CourseV3(title, teacherV6);
        }
    }


    public CourseV3() {
    }

    public CourseV3(String title, TeacherV6 teacherV6) {
        this.title = title;
        this.teacherV6 = teacherV6;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TeacherV6 getTeacherV6() {
        return teacherV6;
    }

    public void setTeacherV6(TeacherV6 teacherV6) {
        this.teacherV6 = teacherV6;
    }
}
