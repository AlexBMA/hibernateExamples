package entity;

import javax.persistence.*;

@Entity
@Table(name = "teacher_profile_v2")
public class TeacherProfileV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "youtube_chanel")
    private String youtubeChanel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "teacher_profile_v2", cascade = CascadeType.ALL)
    private TeacherV2 teacherV2;

    public static class TeacherProfileV2Builder {

        private String youtubeChanel;
        private String hobby;
        private TeacherV2 teacherV2;

        public TeacherProfileV2Builder setYoutubeChanel(String youtubeChanel) {
            this.youtubeChanel = youtubeChanel;
            return this;
        }

        public TeacherProfileV2Builder setHobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public TeacherProfileV2Builder setTeacherV2(TeacherV2 teacherV2) {
            this.teacherV2 = teacherV2;
            return this;
        }

        public TeacherProfileV2 build() {
            return new TeacherProfileV2(youtubeChanel, hobby, teacherV2);
        }

    }

    public TeacherProfileV2() {
    }

    public TeacherProfileV2(String youtubeChanel, String hobby, TeacherV2 teacherV2) {
        this.youtubeChanel = youtubeChanel;
        this.hobby = hobby;
        this.teacherV2 = teacherV2;
    }

    public long getId() {
        return id;
    }

    public TeacherV2 getTeacherV2() {
        return teacherV2;
    }

    public void setTeacherV2(TeacherV2 teacherV2) {
        this.teacherV2 = teacherV2;
    }

    public String getYoutubeChanel() {
        return youtubeChanel;
    }

    public void setYoutubeChanel(String youtubeChanel) {
        this.youtubeChanel = youtubeChanel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "TeacherProfileV2{" +
                "id=" + id +
                ", youtubeChanel='" + youtubeChanel + '\'' +
                ", hobby='" + hobby + '\'' +
                ", teacherV2=" + teacherV2 +
                '}';
    }
}
