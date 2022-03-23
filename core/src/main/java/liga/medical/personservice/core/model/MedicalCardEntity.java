package liga.medical.personservice.core.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class MedicalCardEntity {

    @NotNull
    private Long id;

    private String clientStatus;

    private String medStatus;

    @NotNull
    private LocalDate registryDt;

    private String comment;
}
