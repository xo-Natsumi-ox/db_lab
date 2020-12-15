package com.shevchuk.dao.implementation;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.dao.HospitalDao;
import com.shevchuk.model.HospitalEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class HospitalDaoImpl implements HospitalDao {

    @Override
    public List<HospitalEntity> findAll() {
        Session session = ConnectionManager.getSession();
        List<HospitalEntity> hospitals = session.createQuery("from HospitalEntity ").getResultList();
        return hospitals;
    }

    @Override
    public HospitalEntity findById(Integer id) {
        Session session = ConnectionManager.getSession();
        HospitalEntity hospitalById = session.get(HospitalEntity.class, id);
        return hospitalById;
    }

    @Override
    public void create(HospitalEntity hospital) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.save(hospital);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(HospitalEntity hospital) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.save(hospital);
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
            HospitalEntity hospital = session.get(HospitalEntity.class, id);
            if (hospital != null) {
                session.delete(hospital);
            }
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
        }
    }
}