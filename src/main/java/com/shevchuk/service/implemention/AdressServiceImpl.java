package com.shevchuk.service.implemention;

import com.shevchuk.dao.implementation.AdressDaoImpl;
import com.shevchuk.model.AdressEntity;
import com.shevchuk.service.AdressService;

import java.sql.SQLException;
import java.util.List;

public final class AdressServiceImpl implements AdressService {
    @Override
    public List<AdressEntity> getAll() throws SQLException {
        return new AdressDaoImpl().findAll();
    }

    @Override
    public AdressEntity getById(Integer id) throws SQLException {
        return new AdressDaoImpl().findById(id);
    }

    @Override
    public int create(AdressEntity entity) throws SQLException {
        return new AdressDaoImpl().create(entity);
    }

    @Override
    public int update(AdressEntity entity) throws SQLException {
        return new AdressDaoImpl().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return new AdressDaoImpl().delete(id);
    }
}
