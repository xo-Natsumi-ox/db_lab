package com.shevchuk.controller;

import java.util.List;

public interface GeneralController<T, ID> {

    List<T> findAll();

    T findById(ID id);

    void create(T entity);

    void update(T entity);

    void delete(ID id);

}
