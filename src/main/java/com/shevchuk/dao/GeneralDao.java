package com.shevchuk.dao;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDao<T, ID> {
    List<T> findAll() throws SQLException;

    T findById(ID id) throws SQLException;

    void create(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(ID id) throws SQLException;
}
