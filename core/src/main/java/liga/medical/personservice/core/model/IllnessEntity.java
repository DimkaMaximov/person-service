package liga.medical.personservice.core.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class IllnessEntity {

    @NotNull
    private Long id;

    @NotNull
    private Long medicalCardId;

    private Long typeId;

    private Character heaviness;

    @NotNull
    private LocalDateTime appearanceDttm;

    private LocalDate recoveryDt;
}
