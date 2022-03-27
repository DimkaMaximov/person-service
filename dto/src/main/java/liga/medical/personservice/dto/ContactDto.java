package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

    private Long id;

    private String phoneNumber;

    private String email;

    private String password;

    private String profileLink;

    public ContactDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}