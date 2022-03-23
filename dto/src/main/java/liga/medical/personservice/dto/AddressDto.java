package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private Long id;

    private Long contactId;

    private Long countryId;

    private String city;

    private Integer index;

    private String street;

    private String building;

    private String flat;
}