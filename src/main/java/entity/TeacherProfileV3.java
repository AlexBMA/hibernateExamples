package entity;

import javax.persistence.*;

@Entity
@Table(name = "teacher_profile_v3")
public class TeacherProfileV3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "youtube_chanel")
    private String youtubeChanel;

    @OneToOne(mappedBy = "teacherProfileV3"
            ,cascade = {CascadeType.DETACH
                        , CascadeType.MERGE
                        , CascadeType.PERSIST
                        , CascadeType.REFRESH})

    private TeacherV3 teacherV3;

    public static class TeacherProfileV3Builder {

        private String youtubeChanel;
        private String hobby;
        private TeacherV3 teacherV3;

        public TeacherProfileV3Builder setYoutubeChanel(String youtubeChanel) {
            this.youtubeChanel = youtubeChanel;
            return this;
        }

        public TeacherProfileV3Builder setHobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public TeacherProfileV3Builder setTeacherV2(TeacherV3 teacherV3) {
            this.teacherV3 = teacherV3;
            return this;
        }

        public TeacherProfileV3 build() {
            return new TeacherProfileV3(youtubeChanel, hobby, teacherV3);
        }

    }

    public TeacherProfileV3(String hobby, String youtubeChanel, TeacherV3 teacherV3) {
        this.hobby = hobby;
        this.youtubeChanel = youtubeChanel;
        this.teacherV3 = teacherV3;
    }

    public TeacherProfileV3() {
    }

    public TeacherV3 getTeacherV3() {
        return teacherV3;
    }

    public void setTeacherV3(TeacherV3 teacherV3) {
        this.teacherV3 = teacherV3;
    }

    public long getId() {
        return id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getYoutubeChanel() {
        return youtubeChanel;
    }

    public void setYoutubeChanel(String youtubeChanel) {
        this.youtubeChanel = youtubeChanel;
    }
}
