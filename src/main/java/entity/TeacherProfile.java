package entity;


import javax.persistence.*;

@Entity
@Table(name = "teacher_profile")
public class TeacherProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "youtube_chanel")
    private String youtubeChanel;

    @Column(name = "hobby")
    private String hobby;

    public static class TeacherProfileBuilder {

        private String youtubeChanel;
        private String hobby;

        public TeacherProfileBuilder setYoutubeChanel(String youtubeChanel) {
            this.youtubeChanel = youtubeChanel;
            return this;
        }

        public TeacherProfileBuilder setHobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public TeacherProfile build() {
            return new TeacherProfile(youtubeChanel, hobby);
        }

    }

    public TeacherProfile() {
    }

    public TeacherProfile(String youtubeChanel, String hobby) {
        this.youtubeChanel = youtubeChanel;
        this.hobby = hobby;
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
}
