package com.shevchuk.dao.implementation;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.dao.PatientDao;
import com.shevchuk.model.PatientEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class PatientDaoImpl implements PatientDao {

    @Override
    public List<PatientEntity> findAll() {
        Session session = ConnectionManager.getSession();
        List<PatientEntity> patients = session.createQuery("from PatientEntity ").getResultList();
        return patients;
    }

    @Override
    public PatientEntity findById(Integer id) {
        Session session = ConnectionManager.getSession();
        PatientEntity patientById = session.get(PatientEntity.class, id);
        return patientById;
    }

    @Override
    public void create(PatientEntity patient) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.save(patient);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(PatientEntity patient) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.save(patient);
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
            PatientEntity patient = session.get(PatientEntity.class, id);
            if (patient != null) {
                session.delete(patient);
            }
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
        }
    }
}