package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.ContactEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ContactRepository {

    List<ContactEntity> findAll();

    ContactEntity findById(Long contactId);

    int insertAll(@Param("contactList") List<ContactEntity> contactList);

    int insert(ContactEntity contact);

    boolean updateById(@Param("contact") ContactEntity contact);

    boolean deleteById(@Param("contactId") Long contactId);
}