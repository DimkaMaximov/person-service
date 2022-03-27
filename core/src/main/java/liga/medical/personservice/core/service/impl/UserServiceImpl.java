package liga.medical.personservice.core.service.impl;

import liga.medical.personservice.core.model.ContactEntity;
import liga.medical.personservice.core.model.MedicalCardEntity;
import liga.medical.personservice.core.model.AddressEntity;
import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.model.IllnessEntity;
import liga.medical.personservice.core.repository.UserRepository;
import liga.medical.personservice.core.service.UserService;
import liga.medical.personservice.dto.ContactDto;
import liga.medical.personservice.dto.MedicalCardDto;
import liga.medical.personservice.dto.AddressDto;
import liga.medical.personservice.dto.PersonDataDto;
import liga.medical.personservice.dto.IllnessDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContactDto findContact(Long contactId) {
        ContactEntity contact = repository.findContact(contactId);
        return modelMapper.map(contact, ContactDto.class);
    }

    @Override
    public MedicalCardDto findMedicalCard(Long cardId) {
        MedicalCardEntity medicalCard = repository.findMedicalCard(cardId);
        return modelMapper.map(medicalCard, MedicalCardDto.class);
    }

    @Override
    public AddressDto findAddress(Long addressId) {
        AddressEntity address = repository.findAddress(addressId);
        return modelMapper.map(address, AddressDto.class);
    }

    @Override
    public PersonDataDto findPersonData(Long personDataId) {
        PersonDataEntity personData = repository.findPersonData(personDataId);
        return modelMapper.map(personData, PersonDataDto.class);
    }

    @Override
    public IllnessDto findIllness(Long illnessId) {
        IllnessEntity illness = repository.findIllness(illnessId);
        return modelMapper.map(illness, IllnessDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email);
    }
}