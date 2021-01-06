package com.shevchuk.service;

import com.shevchuk.domain.GeneralEntity;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GeneralService<T extends GeneralEntity> implements ServiceInterface<T> {

  @Override
  public abstract JpaRepository<T, Integer> getRepository();

  @Override
  public List<T> findAll() {
    List<T> entityList = new LinkedList<>(getRepository().findAll());
    if (entityList.isEmpty()) {
      return null;
    }
    return entityList;
  }

  @Override
  public T find(Integer id) {
    Optional<T> optional = getRepository().findById(id);
    if (optional.isPresent()) {
      return optional.get();
    } else {
      return null;
    }
  }

  @Override
  @Transactional
  public T create(T entity) {
    if (entity != null) {
      return getRepository().save(entity);
    }
    return null;
  }

  @Override
  @Transactional
  public T update(T entity) {
    if (entity != null) {
      Optional<T> optional = getRepository().findById(entity.getId());
      if (optional.isPresent()) {
        return getRepository().save(entity);
      } else {
        return null;
      }
    }
    return null;
  }

  @Override
  @Transactional
  public T delete(Integer id) {
    Optional<T> optional = getRepository().findById(id);
    if (optional.isPresent()) {
      getRepository().deleteById(id);
      return optional.get();
    } else {
      return null;
    }
  }
}
