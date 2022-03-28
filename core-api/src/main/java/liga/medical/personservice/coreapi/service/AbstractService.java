package liga.medical.personservice.coreapi.service;

import java.util.List;

public interface AbstractService<T> {

    List<T> findAll();

    T findById(Long id);

    void insertAll(List<T> tList);

    void insert(T t);

    void deleteById(Long id);
}