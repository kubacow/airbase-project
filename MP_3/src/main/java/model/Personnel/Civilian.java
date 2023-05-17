package model.Personnel;

import java.time.LocalDate;

public class Civilian extends Personnel implements ICivilian {

    private float salary;
    private String role;

    public Civilian(String firstName, String lastName, LocalDate dateOfBirth, String personalIdentification, LocalDate dateOfRecruitment, float salary, String role) {
        super(firstName, lastName, dateOfBirth, personalIdentification, dateOfRecruitment);
        this.salary = salary;
        this.role = role;
    }

    @Override
    public float getSalary() {
        return salary;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }
}
