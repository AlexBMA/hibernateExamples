package entity;

import javax.persistence.*;

@Entity
@Table(name = "course_v2")
public class CourseV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "teacher_v5_id")
    private TeacherV5 teacherV5;

    public static class CourseV2Builder {

        private String title;
        private TeacherV5 teacherV5;

        public CourseV2Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public CourseV2Builder setTeacherV5(TeacherV5 teacherV5) {
            this.teacherV5 = teacherV5;
            return this;
        }

        public CourseV2 build() {
            return new CourseV2(title, teacherV5);
        }

    }

    public CourseV2() {
    }

    public CourseV2(String title, TeacherV5 teacherV5) {
        this.title = title;
        this.teacherV5 = teacherV5;
    }

    public TeacherV5 getTeacherV5() {
        return teacherV5;
    }

    public void setTeacherV5(TeacherV5 teacherV5) {
        this.teacherV5 = teacherV5;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
