package liga.medical.personservice.core.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class LogEntity {

    private Long id;

    private LocalDateTime eventTime;

    private String methodName;

    private String className;

    private String email;
}