package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private Long id;

    @NotNull
    private Long contactId;

    @NotNull
    private Long countryId;

    @NotBlank
    private String city;

    private Integer index;

    @NotBlank
    private String street;

    @NotBlank
    private String building;

    private String flat;
}
