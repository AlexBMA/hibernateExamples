package entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "student_v4")
public class StudentV4 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ElementCollection
    @CollectionTable(name = "image_v4")
    @OrderBy("file_name DESC")
    @Column(name = "file_name")
    private Set<String> images = new LinkedHashSet<>();

    public StudentV4() {
    }

    public StudentV4(String firstName, String lastName, String email, Set<String> images) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.images = images;
    }

    public static class StudentV4Builder {

        private String firstName;
        private String lastName;
        private String email;
        private Set<String> images = new LinkedHashSet<>();

        public StudentV4Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentV4Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentV4Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentV4 build() {
            return new StudentV4(firstName, lastName, email, images);
        }
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    public Long getId() {
        return id;
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
