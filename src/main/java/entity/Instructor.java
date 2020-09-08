package entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "INSTRUCTOR")
public class Instructor extends User {

    private Double salary;

    public static class InstructorBuilder extends UserBuilder {

        private Double salary;

        public InstructorBuilder setFirstName(String firstName) {
            super.setFirstName(firstName);
            return this;
        }

        public InstructorBuilder setLastName(String lastName) {
            super.setLastName(lastName);
            return this;
        }

        public InstructorBuilder setEmail(String email) {
            super.setEmail(email);
            return this;
        }

        public InstructorBuilder setSalary(Double salary) {
            this.salary = salary;
            return this;
        }

        public Instructor build() {
            return new Instructor(super.getFirstName(), super.getLastName(), super.getEmail(), salary);
        }
    }

    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String email, Double salary) {
        super(firstName, lastName, email);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
