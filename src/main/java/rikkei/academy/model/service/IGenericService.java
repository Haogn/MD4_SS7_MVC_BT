package rikkei.academy.model.service;

import java.sql.ClientInfoStatus;
import java.util.List;

public interface IGenericService<T, ID> {
    List<T> findAll();
    Boolean save(T t) ;
    T findById(ID id) ;
    Boolean update(T t, ID id) ;
    void delete(ID id) ;
}
