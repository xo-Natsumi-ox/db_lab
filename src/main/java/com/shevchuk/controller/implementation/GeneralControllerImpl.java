package com.shevchuk.controller.implementation;

import com.shevchuk.controller.GeneralController;
import com.shevchuk.service.implementation.GeneralServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public abstract class GeneralControllerImpl<T, ID, SERVICE>
        implements GeneralController<T, ID> {

    private GeneralServiceImpl service;
    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            SESSION_FACTORY = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public GeneralControllerImpl(Class<SERVICE> currentClass) {
        try {
            service = (GeneralServiceImpl) currentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<T> findAll() {
        Session session = null;
        List<T> entities = null;
        try {
            session = SESSION_FACTORY.openSession();
            entities = service.findAll(session);
        } finally {
            session.close();
        }
        return entities;
    }

    @Override
    public T findById(ID id) {
        Session session = null;
        T entity = null;
        try {
            session = SESSION_FACTORY.openSession();
            entity = (T) service.findById(id, session);
        } finally {
            session.close();
        }
        return entity;
    }

    @Override
    public void create(T entity) {
        Session session = null;
        try {
            session = SESSION_FACTORY.openSession();
            service.create(entity, session);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T entity) {
        Session session = null;
        try {
            session = SESSION_FACTORY.openSession();
            service.update(entity, session);
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(ID id) {
        Session session = null;
        try {
            session = SESSION_FACTORY.openSession();
            service.delete(id, session);
        } finally {
            session.close();
        }
    }
}
