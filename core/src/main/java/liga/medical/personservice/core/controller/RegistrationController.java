package liga.medical.personservice.core.controller;

import liga.medical.personservice.coreapi.service.ContactService;
import liga.medical.personservice.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    ContactService service;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addContact(ContactDto contactDto, String message) {
//        ContactDto contact = service.findByEmail(contactDto.getEmail());
//        if(contact != null){
//            message = "User exists, please login";
//            return "redirect:/hello";
//        }
//        contactDto.setPhoneNumber("55555");
//        contactDto.setRoles(Role.ROLE_USER);
//        service.insert(contactDto);
        return "redirect:/login";
    }
}