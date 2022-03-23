package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDataDto {

    private Long id;

    private String lastName;

    private String firstName;

    private LocalDate birthDt;

    private Integer age;

    private Character sex;

    private Long contactId;

    private Long medicalCardId;

    private Long parentId;
}