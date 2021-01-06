package com.shevchuk.controller;

import com.shevchuk.service.ServiceInterface;
import java.sql.SQLException;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface Controller<T> {
  ServiceInterface<T> getService();

  ResponseEntity<List<T>> findAll() throws SQLException;

  ResponseEntity<T> findById(Integer id) throws SQLException;

  ResponseEntity<T> create(T entity) throws SQLException;

  ResponseEntity<T> update(Integer id, T entity) throws SQLException;

  ResponseEntity<T> delete(Integer id) throws SQLException;

}
