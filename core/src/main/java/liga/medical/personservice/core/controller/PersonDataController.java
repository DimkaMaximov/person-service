package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.service.PersonDataService;
import liga.medical.personservice.dto.PersonDataDto;
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
@RequestMapping("admin/data")
public class PersonDataController {

    @Autowired
    private PersonDataService service;

    @GetMapping("")
    List<PersonDataDto> getPersonData() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    PersonDataDto getPersonDataById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save-all")
    void saveNewPersonDataList(@RequestBody @Valid List<PersonDataDto> personDataDtoList) {
        service.insertAll(personDataDtoList);
    }

    @PostMapping("/save")
    void saveNewPersonData(@RequestBody @Valid PersonDataDto personDataDto) {
        service.insert(personDataDto);
    }

    @PostMapping("/{id}/remove")
    void deleteIllness(@PathVariable Long id) {
        service.deleteById(id);
    }
}