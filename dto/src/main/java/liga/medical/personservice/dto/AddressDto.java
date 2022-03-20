package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    @NotNull
    private Long id;

    @NotNull
    private Long contactId;

    @NotNull
    private Long countryId;

    @NotNull
    private String city;

    private Integer index;

    @NotNull
    private String street;

    @NotNull
    private String building;

    private String flat;
}
