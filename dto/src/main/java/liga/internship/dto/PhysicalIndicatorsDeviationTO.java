package liga.internship.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalIndicatorsDeviationTO {

    private Long userId;

    private String deviation;
}
