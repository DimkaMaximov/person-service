package liga.internship.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalDevicesInformationTO {

    private Long deviceId;

    private Long userId;

    private String information;
}
