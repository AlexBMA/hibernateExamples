package entity;

import javax.persistence.Entity;

@Entity
public class InstructorV2 extends UserV2 {

    private Double salary;

    public static class InstructorV2Builder extends UserV2Builder {

        private Double salary;

        public InstructorV2Builder setSalary(Double salary) {
            this.salary = salary;
            return this;
        }

        public InstructorV2Builder setFirstName(String firstName) {
            super.setFirstName(firstName);
            return this;
        }

        public InstructorV2Builder setLastName(String lastName) {
            super.setLastName(lastName);
            return this;
        }

        public InstructorV2Builder setEmail(String email) {
            super.setEmail(email);
            return this;
        }

        public InstructorV2 build() {
            return new InstructorV2(super.getFirstName(), super.getLastName(), super.getEmail(), this.salary);
        }

    }

    public InstructorV2(String firstName, String lastName, String email, Double salary) {
        super(firstName, lastName, email);
        this.salary = salary;
    }

    public InstructorV2() {
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
