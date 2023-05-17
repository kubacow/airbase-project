package model.Personnel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString

public abstract class Personnel {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String personalIdentification;
    private LocalDate dateOfRecruitment;

    public Personnel(String firstName, String lastName, LocalDate dateOfBirth, String personalIdentification, LocalDate dateOfRecruitment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.personalIdentification = personalIdentification;
        this.dateOfRecruitment = dateOfRecruitment;
    }
}
