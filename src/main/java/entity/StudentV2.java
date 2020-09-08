package entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_v2")
public class StudentV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstNme;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ElementCollection
    @CollectionTable(name = "image_v2")
    @OrderColumn
    @Column(name = "file_name")
    private List<String> images = new ArrayList<>();

    public static class StudentV2Builder {

        private String firstNme;
        private String lastName;
        private String email;
        private List<String> images = new ArrayList<>();

        public StudentV2Builder setFirstNme(String firstNme) {
            this.firstNme = firstNme;
            return this;
        }

        public StudentV2Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentV2Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentV2Builder setImages(List<String> images) {
            this.images = images;
            return this;
        }


        public StudentV2 build() {
            return new StudentV2(firstNme, lastName, email, images);
        }


    }


    public StudentV2(String firstNme, String lastName, String email, List<String> images) {
        this.firstNme = firstNme;
        this.lastName = lastName;
        this.email = email;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public String getFirstNme() {
        return firstNme;
    }

    public void setFirstNme(String firstNme) {
        this.firstNme = firstNme;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "StudentV2{" +
                "id=" + id +
                ", firstNme='" + firstNme + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", images=" + images +
                '}';
    }
}
