package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.ContactEntity;
import liga.medical.personservice.core.model.MedicalCardEntity;
import liga.medical.personservice.core.model.AddressEntity;
import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.model.IllnessEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {

    @Select("select * from contact where id = #{id}")
    ContactEntity findContact(Long id);

    @Select("select * from medical_card where id = #{id}")
    MedicalCardEntity findMedicalCard(Long id);

    @Select("select * from address where contact_id = #{id}")
    AddressEntity findAddress(Long id);

    @Select("select * from person_data where contact_id = #{id}")
    PersonDataEntity findPersonData(Long id);

    @Select("select * from illness where medical_card_id = #{id}")
    IllnessEntity findIllness(Long id);

    @Select("select * from contact where email = #{email}")
    ContactEntity findByEmail(String email);
}