package model.Personnel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString

public abstract class Personnel {
    protected String firstName;
    protected String lastName;
    protected LocalDate dateOfBirth;
    protected String personalIdentification;
    protected LocalDate dateOfRecruitment;
    protected String sex; // multi-aspect: inheritance based on different aspects (role and sex)

    public Personnel(String firstName, String lastName, LocalDate dateOfBirth, String personalIdentification,
                     LocalDate dateOfRecruitment, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.personalIdentification = personalIdentification;
        this.dateOfRecruitment = dateOfRecruitment;
        this.sex = sex;
    }
}
