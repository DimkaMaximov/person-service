package liga.medical.personservice.coreapi.service;

import liga.medical.personservice.dto.AddressDto;
import liga.medical.personservice.dto.ContactDto;
import liga.medical.personservice.dto.MedicalCardDto;
import liga.medical.personservice.dto.PersonDataDto;
import liga.medical.personservice.dto.IllnessDto;

public interface UserService {

    ContactDto findContact(Long contactId);

    MedicalCardDto findMedicalCard(Long cardId);

    AddressDto findAddress(Long addressId);

    PersonDataDto findPersonData(Long personDataId);

    IllnessDto findIllness(Long illnessId);
}
