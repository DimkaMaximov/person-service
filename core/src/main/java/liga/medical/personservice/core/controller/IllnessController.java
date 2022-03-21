package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.service.IllnessService;
import liga.medical.personservice.dto.IllnessDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/illness")
public class IllnessController {

    @Autowired
    private IllnessService service;

    @GetMapping("/all")
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