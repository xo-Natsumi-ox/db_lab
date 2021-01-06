package com.shevchuk.service;

import java.sql.SQLException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface ServiceInterface<T> {

  JpaRepository<T, Integer> getRepository();

  List<T> findAll() throws SQLException;

  T find(Integer id) throws SQLException;

  @Transactional
  T delete(Integer id) throws SQLException;

  @Transactional
  T update(T entity) throws SQLException;

  @Transactional
  T create(T entity) throws SQLException;

}
