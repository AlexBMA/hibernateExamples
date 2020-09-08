package entity;

import javax.persistence.Entity;

@Entity
public class InstructorV3 extends UserV3 {

    private Double salary;

    public static class InstructorV3Builder extends UserV3Builder {

        private Double salary;

        public InstructorV3Builder setSalary(Double salary) {
            this.salary = salary;
            return this;
        }


        public InstructorV3Builder setFirstName(String firstName) {
            super.setFirstName(firstName);
            return this;
        }

        public InstructorV3Builder setLastName(String lastName) {
            super.setLastName(lastName);
            return this;
        }

        public InstructorV3Builder setEmail(String email) {
            super.setEmail(email);
            return this;
        }

        public InstructorV3 build() {
            return new InstructorV3(super.getFirstName(), super.getLastName(), super.getEmail(), salary);
        }

    }

    public InstructorV3() {
    }

    public InstructorV3(String firstName, String lastName, String email, Double salary) {
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
