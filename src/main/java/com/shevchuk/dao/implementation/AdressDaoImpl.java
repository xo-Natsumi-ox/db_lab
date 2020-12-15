package com.shevchuk.dao.implementation;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.dao.AdressDao;
import com.shevchuk.model.AdressEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class AdressDaoImpl implements AdressDao {

    @Override
    public List<AdressEntity> findAll() {
        Session session = ConnectionManager.getSession();
        List<AdressEntity> adresses = session.createQuery("from AdressEntity ").getResultList();
        return adresses;
    }

    @Override
    public AdressEntity findById(Integer id) {
        Session session = ConnectionManager.getSession();
        AdressEntity adressById = session.get(AdressEntity.class, id);
        return adressById;
    }

    @Override
    public void create(AdressEntity adress) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.save(adress);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(AdressEntity adress) {
        Session session = ConnectionManager.getSession();
        try {
            session.beginTransaction();
            session.save(adress);
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
            AdressEntity adress = session.get(AdressEntity.class, id);
            if (adress != null) {
                session.delete(adress);
            }
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
        }
    }
}