package com.shevchuk.dao;

import java.util.List;

public interface GeneralDao<T, ID> {

    List<T> findAll();

    T findById(ID id);

    void create(T entity);

    void update(T entity);

    void delete(ID id);

    Class<T> getObjClass();

}
