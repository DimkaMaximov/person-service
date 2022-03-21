package liga.medical.personservice.core.service.impl;

import liga.medical.personservice.core.model.ContactEntity;
import liga.medical.personservice.core.repository.ContactRepository;
import liga.medical.personservice.core.service.ContactService;
import liga.medical.personservice.dto.ContactDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ContactDto> findAll() {
        List<ContactEntity> contactList = repository.findAll();
        return contactList.stream()
                .map(el -> modelMapper.map(el, ContactDto.class))
                .collect(Collectors.toList());
    }

    public ContactDto findById(Long id) {
        ContactEntity contact = repository.findById(id);
        return modelMapper.map(contact, ContactDto.class);
    }

    public void insertAll(List<ContactDto> contactDtoList) {
        List<ContactEntity> contactList = contactDtoList.stream()
                .map(el -> modelMapper.map(el, ContactEntity.class))
                .collect(Collectors.toList());
        repository.insertAll(contactList);
    }

    public void insert(ContactDto contactDto) {
        ContactEntity contact = modelMapper.map(contactDto, ContactEntity.class);
        if (contact.getId() == null) repository.insert(contact);
        else repository.updateById(contact);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}