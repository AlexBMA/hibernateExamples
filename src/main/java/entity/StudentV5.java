package entity;

import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "student_v5")
public class StudentV5 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


    @ElementCollection
    @CollectionTable(name = "image_v5")
    @MapKeyColumn(name = "file_name")
    @Column(name = "image_description")
    //@OrderBy("image_description DESC")
    @SortComparator(ReverseStringComparator.class)
    private SortedMap<String, String> images = new TreeMap<>();

    public static class ReverseStringComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }

    public StudentV5() {
    }

    public StudentV5(String firstName, String lastName, String email, SortedMap<String, String> images) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.images = images;
    }

    public static class StudentBuilder {

        private String firstName;
        private String lastName;
        private String email;
        private SortedMap<String, String> images = new TreeMap<>();

        public StudentBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder setImages(SortedMap<String, String> images) {
            this.images = images;
            return this;
        }

        public StudentV5 build() {
            return new StudentV5(firstName, lastName, email, images);
        }

    }


    public long getId() {
        return id;
    }

    public Map<String, String> getImages() {
        return images;
    }

    public void setImages(SortedMap<String, String> images) {
        this.images = images;
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
