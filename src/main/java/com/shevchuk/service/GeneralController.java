package com.shevchuk.service;

import java.sql.SQLException;
import java.util.List;

public interface GeneralController<T, ID> {
    List<T> getAll() throws SQLException;

    T getById(Integer id) throws SQLException;

    void create(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(Integer id) throws SQLException;
}
