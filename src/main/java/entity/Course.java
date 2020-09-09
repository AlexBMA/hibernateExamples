package entity;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST
            , CascadeType.MERGE
            , CascadeType.DETACH
            , CascadeType.REFRESH})

    @JoinColumn(name = "teacherV4_id")
    private TeacherV4 teacherV4;

    public static class CourseBuilder {

        private String title;
        private TeacherV4 teacherV4;

        public CourseBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public CourseBuilder setTeacherV4(TeacherV4 teacherV4) {
            this.teacherV4 = teacherV4;
            return this;
        }

        public Course build() {
            return new Course(title, teacherV4);
        }
    }


    public Course(String title, TeacherV4 teacherV4) {
        this.title = title;
        this.teacherV4 = teacherV4;
    }

    public Course() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TeacherV4 getTeacherV4() {
        return teacherV4;
    }

    public void setTeacherV4(TeacherV4 teacherV4) {
        this.teacherV4 = teacherV4;
    }
}
