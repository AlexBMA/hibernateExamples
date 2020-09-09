package entity;

import javax.persistence.*;

@Entity
@Table(name = "teacher_v2")
public class TeacherV2 {

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
    @JoinColumn(name = "teacher_profile_v2")
    private TeacherProfileV2 teacher_profile_v2;

    public static class TeacherV2Builder {

        private String firstName;
        private String lastName;
        private String email;
        private TeacherProfileV2 teacherProfileV2;

        public TeacherV2Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TeacherV2Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TeacherV2Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public TeacherV2Builder setTeacherProfileV2(TeacherProfileV2 teacherProfileV2) {
            this.teacherProfileV2 = teacherProfileV2;
            return this;
        }

        public TeacherV2 build() {
            return new TeacherV2(firstName, lastName, email, teacherProfileV2);
        }
    }


    public TeacherV2() {
    }

    public TeacherV2(String firstName, String lastName, String email, TeacherProfileV2 teacher_profile_v2) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.teacher_profile_v2 = teacher_profile_v2;
    }

    public TeacherProfileV2 getTeacher_profile_v2() {
        return teacher_profile_v2;
    }

    public void setTeacher_profile_v2(TeacherProfileV2 teacher_profile_v2) {
        this.teacher_profile_v2 = teacher_profile_v2;
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

    @Override
    public String toString() {
        return "TeacherV2{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", teacher_profile_v2=" + teacher_profile_v2 +
                '}';
    }
}
