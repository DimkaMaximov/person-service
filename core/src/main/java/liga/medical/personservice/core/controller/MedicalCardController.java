package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.service.MedicalCardService;
import liga.medical.personservice.dto.MedicalCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("admin/medical-card")
public class MedicalCardController {

    @Autowired
    private MedicalCardService service;

    @PostMapping("/save")
    void saveNewMedicalCard(@RequestBody @Valid MedicalCardDto medicalCard) {
        service.insert(medicalCard);
    }

    @PostMapping("/save-all")
    void saveNewMedicalCard(@RequestBody @Valid List<MedicalCardDto> medicalCard) {
        service.insertAll(medicalCard);
    }

    @GetMapping("/{id}")
    MedicalCardDto getCardById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/all")
    List<MedicalCardDto> getMedicalCards() {
        return service.findAll();
    }

    @PostMapping("/{id}/remove")
    void deleteMedicalCard(@PathVariable Long id) {
        service.deleteById(id);
    }
}