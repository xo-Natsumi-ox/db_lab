package com.shevchuk.service;

import com.shevchuk.dao.GeneralDao;

import java.util.List;

public interface GeneralService<T, ID> {
    List<T> findAll();

    T findById(ID id);

    void create(T entity);

    void update(T entity);

    void delete(ID id);

    GeneralDao<T, ID> getDao();
}
