package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.IllnessEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IllnessRepository {

    List<IllnessEntity> findAll();

    IllnessEntity findById(Long illnessId);

    int insertAll(@Param("illnessList") List<IllnessEntity> illnessList);

    int insert(IllnessEntity illness);

    boolean updateById(@Param("illness") IllnessEntity illness);

    boolean deleteById(@Param("illnessId") Long illnessId);
}