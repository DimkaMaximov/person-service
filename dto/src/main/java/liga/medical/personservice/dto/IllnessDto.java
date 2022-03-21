package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IllnessDto {

    private Long id;

    @NotNull
    private Long medicalCardId;

    private Long typeId;

    private Character heaviness;

    @NotNull
    private LocalDateTime appearanceDttm;

    private LocalDate recoveryDt;
}
