package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.service.AddressService;
import liga.medical.personservice.dto.AddressDto;
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
@RequestMapping("admin/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping("")
    List<AddressDto> getAddresses() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    AddressDto getAddressById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save-all")
    void saveNewAddresses(@RequestBody @Valid List<AddressDto> addressDtoList) {
        service.insertAll(addressDtoList);
    }

    @PostMapping("/save")
    void saveNewAddress(@RequestBody @Valid AddressDto addressDto) {
        service.insert(addressDto);
    }

    @PostMapping("/{id}/remove")
    void deleteContact(@PathVariable Long id) {
        service.deleteById(id);
    }
}