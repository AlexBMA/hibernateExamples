package entity;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_profile_id")
    private TeacherProfile teacherProfile;

    public static class TeacherBuilder {

        private String firstName;
        private String lastName;
        private String email;
        private TeacherProfile teacherProfile;


        public TeacherBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TeacherBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TeacherBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public TeacherBuilder setTeacherProfile(TeacherProfile teacherProfile) {
            this.teacherProfile = teacherProfile;
            return this;
        }

        public Teacher build() {
            return new Teacher(firstName, lastName, email, teacherProfile);
        }
    }

    public Teacher(String firstName, String lastName, String email, TeacherProfile teacherProfile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.teacherProfile = teacherProfile;
    }

    public Teacher() {
    }


    public TeacherProfile getTeacherProfile() {
        return teacherProfile;
    }

    public void setTeacherProfile(TeacherProfile teacherProfile) {
        this.teacherProfile = teacherProfile;
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
