package entity;

import javax.persistence.*;

@Entity
@Table(name = "teacher_v3")
public class TeacherV3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_profile_v3_id")
    private TeacherProfileV3 teacherProfileV3;


    public static class TeacherV3Builder {

        private String firstName;
        private String lastName;
        private String email;
        private TeacherProfileV3 teacherProfileV3;

        public TeacherV3Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TeacherV3Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TeacherV3Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public TeacherV3Builder setTeacherProfileV3(TeacherProfileV3 teacherProfileV3) {
            this.teacherProfileV3 = teacherProfileV3;
            return this;
        }

        public TeacherV3 build() {
            return new TeacherV3(firstName, lastName, email, teacherProfileV3);
        }
    }

    public TeacherV3() {
    }

    public TeacherV3(String firstName, String lastName, String email, TeacherProfileV3 teacherProfileV3) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.teacherProfileV3 = teacherProfileV3;
    }

    public long getId() {
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

    public TeacherProfileV3 getTeacherProfileV3() {
        return teacherProfileV3;
    }

    public void setTeacherProfileV3(TeacherProfileV3 teacherProfileV3) {
        this.teacherProfileV3 = teacherProfileV3;
    }
}
