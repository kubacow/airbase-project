package model.Personnel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

public class Military extends Personnel {

    private String rank;
    private String specialization;
    private List<String> languages = new ArrayList<>();
    private String bloodType;

    public Military(String firstName, String lastName, LocalDate dateOfBirth, String personalIdentification,
                    LocalDate dateOfRecruitment, String rank, String specialization, List<String> languages,
                    String bloodType) {
        super(firstName, lastName, dateOfBirth, personalIdentification, dateOfRecruitment);
        this.rank = rank;
        this.specialization = specialization;
        this.languages = languages;
        this.bloodType = bloodType;
    }
}
