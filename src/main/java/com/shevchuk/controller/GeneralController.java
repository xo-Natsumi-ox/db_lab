package com.shevchuk.controller;

import com.shevchuk.service.GeneralService;

public interface GeneralController<T, ID> {
    void findAll();

    void findById(ID id);

    void create(T entity);

    void update(T entity);

    void delete(ID id);

    GeneralService<T, ID> getService();

    T getEntityById(ID id);
}
