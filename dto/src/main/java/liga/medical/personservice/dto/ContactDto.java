package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

    @NotNull
    private Long id;

    private String phoneNumber;

    @NotNull
    private String email;

    private String profileLink;

}
