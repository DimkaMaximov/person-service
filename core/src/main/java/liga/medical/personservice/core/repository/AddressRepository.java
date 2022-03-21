package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.AddressEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddressRepository {

    List<AddressEntity> findAll();

    AddressEntity findById(Long addressId);

    int insertAll(@Param("addressList") List<AddressEntity> addressList);

    int insert(AddressEntity address);

    boolean updateById(@Param("address") AddressEntity address);

    boolean deleteById(@Param("addressId") Long addressId);
}