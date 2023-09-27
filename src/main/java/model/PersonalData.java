package model;

import enums.MonthOfBirth;
import lombok.Data;

@Data
public class PersonalData {
    private String firstName;
    private String lastName;
    private String newPassword;
    private MonthOfBirth monthOfBirth;
}
