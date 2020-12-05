package com.shevchuk.service.implemention;

import com.shevchuk.dao.implementation.PatientDaoImpl;
import com.shevchuk.model.PatientEntity;
import com.shevchuk.service.PatientService;

import java.sql.SQLException;
import java.util.List;

public final class PatientServiceImpl implements PatientService {
    @Override
    public List<PatientEntity> getAll() throws SQLException {
        return new PatientDaoImpl().findAll();
    }

    @Override
    public PatientEntity getById(Integer id) throws SQLException {
        return new PatientDaoImpl().findById(id);
    }

    @Override
    public int create(PatientEntity entity) throws SQLException {
        return new PatientDaoImpl().create(entity);
    }

    @Override
    public int update(PatientEntity entity) throws SQLException {
        return new PatientDaoImpl().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return new PatientDaoImpl().delete(id);
    }
}
