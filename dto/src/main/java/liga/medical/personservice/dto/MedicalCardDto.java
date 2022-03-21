package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardDto {

    private Long id;

    private String clientStatus;

    private String medStatus;

    @NotNull
    private LocalDate registryDt;

    private String comment;
}
