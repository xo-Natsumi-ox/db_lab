package com.shevchuk.dao.implementation;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.dao.SheduleDao;
import com.shevchuk.model.SheduleEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class SheduleDaoImpl implements SheduleDao {

    @Override
    public List<SheduleEntity> findAll() {
        Session session = ConnectionManager.getSession();
        List<SheduleEntity> shedules = session.createQuery("from SheduleEntity ").getResultList();
        return shedules;
    }

    @Override
    public SheduleEntity findById(Integer id) {
        Session session = ConnectionManager.getSession();
        SheduleEntity sheduleById = session.get(SheduleEntity.class, id);
        return sheduleById;
    }

    @Override
    public void create(SheduleEntity shedule) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.save(shedule);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(SheduleEntity shedule) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.save(shedule);
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
            SheduleEntity shedule = session.get(SheduleEntity.class, id);
            if (shedule != null) {
                session.delete(shedule);
            }
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
        }
    }
}
