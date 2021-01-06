package com.shevchuk.service;

import org.hibernate.Session;

import java.util.List;

public interface GeneralService<T, ID> {

    List<T> findAll(Session session);

    T findById(ID id, Session session);

    void create(T entity, Session session);

    void update(T entity, Session session);

    void delete(ID id, Session session);

}
