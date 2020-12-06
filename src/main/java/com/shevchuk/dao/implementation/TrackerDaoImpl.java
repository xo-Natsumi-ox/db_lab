package com.shevchuk.dao.implementation;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.dao.TrackerDao;
import com.shevchuk.model.TrackerEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class TrackerDaoImpl implements TrackerDao {

    @Override
    public List<TrackerEntity> findAll() {
        Session session = ConnectionManager.getSession();
        List<TrackerEntity> trackers = session.createQuery("from TrackerEntity ").getResultList();
        return trackers;
    }

    @Override
    public TrackerEntity findById(Integer id) {
        Session session = ConnectionManager.getSession();
        TrackerEntity trackerById = session.get(TrackerEntity.class, id);
        return trackerById;
    }

    @Override
    public void create(TrackerEntity tracker) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.save(tracker);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(TrackerEntity tracker) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.save(tracker);
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Integer id) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            TrackerEntity tracker = session.get(TrackerEntity.class, id);
            if (tracker != null) {
                session.delete(tracker);
            }
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
        }
    }
}
