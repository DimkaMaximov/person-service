package liga.medical.personservice.core.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ContactEntity {

    @NotNull
    private Long id;

    @NotBlank
    private String phoneNumber;

    private String email;

    private String profileLink;
}
