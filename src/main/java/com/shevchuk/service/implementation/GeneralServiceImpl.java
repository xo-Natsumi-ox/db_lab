package com.shevchuk.service.implementation;

import com.shevchuk.dao.GeneralDao;
import com.shevchuk.service.GeneralService;
import org.hibernate.Session;

import java.util.List;

public abstract class GeneralServiceImpl<T, ID, DAO>
        implements GeneralService<T, ID> {

    private GeneralDao<T, ID> getDao;


    public GeneralServiceImpl(Class<DAO> currentClass) {
        try {
            getDao = (GeneralDao<T, ID>) currentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> findAll(Session session) {
        return getDao.findAll(session);
    }

    @Override
    public T findById(ID id, Session session) {
        return getDao.findById(id, session);
    }

    @Override
    public void create(T entity, Session session) {
        getDao.create(entity, session);
    }

    @Override
    public void update(T entity, Session session) {
        getDao.update(entity, session);
    }

    @Override
    public void delete(ID id, Session session) {
        getDao.delete(id, session);
    }
}
