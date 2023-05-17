package model.Personnel;

import java.time.LocalDate;
import java.util.List;

public class PMC extends Military implements ICivilian {

    private Civilian civilian;
    private String companyName;
    private String securityClearance;

    public PMC(String firstName, String lastName, LocalDate dateOfBirth, String personalIdentification,
               LocalDate dateOfRecruitment, float salary, String role, String rank, String specialization,
               List<String> languages, String bloodType, String companyName, String securityClearance) {
        super(firstName, lastName, dateOfBirth, personalIdentification,
                dateOfRecruitment, rank, specialization, languages, bloodType);
        this.companyName = companyName;
        this.securityClearance = securityClearance;
        civilian = new Civilian(null, null, null, null, null,
                                salary, role);
    }

    @Override
    public float getSalary() {
        return civilian.getSalary();
    }

    @Override
    public String getRole() {
        return civilian.getRole();
    }

    @Override
    public void setSalary(float salary) {
        civilian.setSalary(salary);
    }

    @Override
    public void setRole(String role) {
        civilian.setRole(role);
    }
}