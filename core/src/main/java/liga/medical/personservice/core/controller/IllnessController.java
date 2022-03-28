package liga.medical.personservice.core.controller;

import liga.medical.personservice.coreapi.service.IllnessService;
import liga.medical.personservice.dto.IllnessDto;
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
@RequestMapping("admin/illness")
public class IllnessController {

    @Autowired
    private IllnessService service;

    @GetMapping("")
    List<IllnessDto> getIllnesses() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    IllnessDto getIllnessById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save-all")
    void saveNewIllnesses(@RequestBody @Valid List<IllnessDto> illnessDtoList) {
        service.insertAll(illnessDtoList);
    }

    @PostMapping("/save")
    void saveNewIllness(@RequestBody @Valid IllnessDto illnessDto) {
        service.insert(illnessDto);
    }

    @PostMapping("/{id}/remove")
    void deleteIllness(@PathVariable Long id) {
        service.deleteById(id);
    }
}