package entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "student_v3")
public class StudentV3 {

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
    @CollectionTable(name = "image_v3")
    @MapKeyColumn(name = "file_name")
    @Column(name = "image_description")
    private Map<String, String> images = new HashMap<>();

    public StudentV3(String firstName, String lastName, String email, Map<String, String> images) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.images = images;
    }

    public static class StudentV3Builder {
        private String firstName;
        private String lastName;
        private String email;
        private Map<String, String> images = new HashMap<>();

        public StudentV3Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentV3Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentV3Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentV3Builder setImages(Map<String, String> images) {
            this.images = images;
            return this;
        }

        public StudentV3 build() {
            return new StudentV3(firstName, lastName, email, images);
        }
    }

    public Map<String, String> getImages() {
        return images;
    }

    public void setImages(Map<String, String> images) {
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
