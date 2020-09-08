package entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_v4")
public class InstructorV4 extends UserV4 {

    @Column(name = "salary")
    private Double salary;

    public static class InstructorV4Builder extends UserV4Builder {

        private Double salary;

        public InstructorV4Builder setSalary(Double salary) {
            this.salary = salary;
            return this;
        }


        public InstructorV4Builder setFirstName(String firstName) {
            super.setFirstName(firstName);
            return this;
        }

        public InstructorV4Builder setLastName(String lastName) {
            super.setLastName(lastName);
            return this;
        }

        public InstructorV4Builder setEmail(String email) {
            super.setEmail(email);
            return this;
        }

        public InstructorV4 build() {
            return new InstructorV4(super.getFirstName(), super.getLastName(), super.getEmail(), salary);
        }

    }


    public InstructorV4(String firstName, String lastName, String email, Double salary) {
        super(firstName, lastName, email);
        this.salary = salary;
    }

    public InstructorV4(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
