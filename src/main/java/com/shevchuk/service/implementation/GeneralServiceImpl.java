package com.shevchuk.service.implementation;

import com.shevchuk.dao.GeneralDao;
import com.shevchuk.service.GeneralService;

import java.util.List;

public abstract class GeneralServiceImpl<T, ID> implements GeneralService<T, ID> {

    @Override
    public abstract GeneralDao<T, ID> getDao();

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public T findById(final ID id) {
        return getDao().findById(id);
    }

    @Override
    public void create(final T entity) {
        getDao().create(entity);
    }

    @Override
    public void update(final T entity) {
        getDao().update(entity);
    }

    @Override
    public void delete(final ID id) {
        getDao().delete(id);
    }
}

