package com.shevchuk.dao.implementation;

import com.shevchuk.dao.GeneralDao;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.LinkedList;
import java.util.List;

public abstract class GeneralDaoImpl<T, ID> implements GeneralDao<T, ID> {

    private final Class<T> currentClass;

    public GeneralDaoImpl(Class<T> currentClass) {
        this.currentClass = currentClass;
    }

    @Override
    public List<T> findAll(Session session) {
        List<T> entities = new LinkedList<>();

        Query query = session.createQuery("from "
                + currentClass.getSimpleName());
        for (Object entity : query.getResultList()) {
            entities.add((T) entity);
        }
        return entities;
    }

    @Override
    public T findById(ID id, Session session) {
        return session.get(currentClass, (Integer) id);
    }

    @Override
    public void create(T entity, Session session) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(T entity, Session session) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(ID id, Session session) {
        session.beginTransaction();
        T entity = findById(id, session);
        session.delete(entity);
        session.getTransaction().commit();
    }
}
