package com.dealz.registration.dao.commons;

import java.io.Serializable;
import java.util.List;

public interface AbstractDAO<T extends Serializable> {

    Class<T> getEntityClass();

    T getById(final Serializable id);

    List<T> getAll();

    T save(T object);

    T update(T object);

    T saveOrUpdate(T object);

    T getByNaturalId(final Serializable naturalId);
    
    void delete(T object);
    
    void detach(T object);
    
    T merge(T object);
    
    void flush();

}
