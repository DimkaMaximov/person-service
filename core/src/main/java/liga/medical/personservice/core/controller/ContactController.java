package liga.medical.personservice.core.controller;

import liga.medical.personservice.coreapi.service.ContactService;
import liga.medical.personservice.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("admin/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping("")
    List<ContactDto> getContacts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    ContactDto getContactById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save-all")
    void saveNewContacts(@RequestBody @Valid List<ContactDto> contactDtoList) {
        service.insertAll(contactDtoList);
    }

    @PostMapping("/save")
    void saveNewContact(@RequestBody @Valid ContactDto contactDto) {
        service.insert(contactDto);
    }

    @PostMapping("/{id}/remove")
    void deleteContact(@PathVariable Long id) {
        service.deleteById(id);
    }
}