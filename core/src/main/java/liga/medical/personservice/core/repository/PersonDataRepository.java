package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.PersonDataEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonDataRepository {

    List<PersonDataEntity> findAll();

    PersonDataEntity findById(Long personDataId);

    int insertAll(@Param("personDataList") List<PersonDataEntity> personDataList);

    int insert(PersonDataEntity personData);

    boolean updateById(@Param("personData") PersonDataEntity personData);

    boolean deleteById(@Param("personDataId") Long personDataId);
}