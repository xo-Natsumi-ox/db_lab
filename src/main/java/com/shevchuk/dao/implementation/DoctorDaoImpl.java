package com.shevchuk.dao.implementation;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.dao.DoctorDao;
import com.shevchuk.model.DoctorEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class DoctorDaoImpl implements DoctorDao {

    @Override
    public List<DoctorEntity> findAll() {
        Session session = ConnectionManager.getSession();
        List<DoctorEntity> doctors = session.createQuery("from DoctorEntity ").getResultList();
        return doctors;
    }

    @Override
    public DoctorEntity findById(Integer id) {
        Session session = ConnectionManager.getSession();
        DoctorEntity doctorById = session.get(DoctorEntity.class, id);
        return doctorById;
    }

    @Override
    public void create(DoctorEntity doctor) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.save(doctor);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(DoctorEntity doctor) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.save(doctor);
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
            DoctorEntity doctor = session.get(DoctorEntity.class, id);
            if (doctor != null) {
                session.delete(doctor);
            }
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
        }
    }
}