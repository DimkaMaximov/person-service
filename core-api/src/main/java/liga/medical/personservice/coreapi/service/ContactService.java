package liga.medical.personservice.coreapi.service;

import liga.medical.personservice.dto.ContactDto;

public interface ContactService extends AbstractService<ContactDto> {
    ContactDto findByEmail(String email);
}