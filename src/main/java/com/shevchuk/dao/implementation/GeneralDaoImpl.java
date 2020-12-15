package com.shevchuk.dao.implementation;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.dao.GeneralDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public abstract class GeneralDaoImpl<T, ID> implements GeneralDao<T, ID> {
    @Override
    public abstract Class<T> getObjClass();

    @Override
    public List<T> findAll() {
        Session session = ConnectionManager.getSession();
        Query query = session.createQuery("from " + getObjClass().getSimpleName());
        return (List<T>) query.list();
    }

    @Override
    public T findById(ID id) {
        Session session = ConnectionManager.getSession();
        return session.get(getObjClass(), (Serializable) id);
    }

    @Override
    public void create(T objct) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.save(objct);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(T objct) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.update(objct);
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void delete(ID id) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            T object = session.get(getObjClass(), (Serializable) id);
            if (object != null) {
                session.delete(object);
            }
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
        }
    }
}
//SheduleEntity.class => getObjDao