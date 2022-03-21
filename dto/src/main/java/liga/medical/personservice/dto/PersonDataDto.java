package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDataDto {

    private Long id;

    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    @NotNull
    private LocalDate birthDt;

    private Integer age;

    @NotNull
    private Character sex;

    @NotNull
    private Long contactId;

    @NotNull
    private Long medicalCardId;

    private Long parentId;
}
