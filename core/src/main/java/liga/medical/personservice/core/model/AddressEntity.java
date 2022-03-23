package liga.medical.personservice.core.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddressEntity {

    @NotNull
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
