package liga.medical.personservice.core.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PersonDataEntity {

    @NotNull
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
