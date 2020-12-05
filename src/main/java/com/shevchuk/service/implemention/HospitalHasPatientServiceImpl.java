package com.shevchuk.service.implemention;

import com.shevchuk.dao.implementation.HospitalHasPatientDaoImpl;
import com.shevchuk.model.HospitalHasPatientEntity;
import com.shevchuk.service.HospitalHasPatientService;

import java.sql.SQLException;
import java.util.List;

public final class HospitalHasPatientServiceImpl implements HospitalHasPatientService {
    @Override
    public List<HospitalHasPatientEntity> getAll() throws SQLException {
        return new HospitalHasPatientDaoImpl().findAll();
    }

    @Override
    public HospitalHasPatientEntity getById(Integer id) throws SQLException {
        return new HospitalHasPatientDaoImpl().findById(id);
    }

    @Override
    public int create(HospitalHasPatientEntity entity) throws SQLException {
        return new HospitalHasPatientDaoImpl().create(entity);
    }

    @Override
    public int update(HospitalHasPatientEntity entity) throws SQLException {
        return new HospitalHasPatientDaoImpl().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return new HospitalHasPatientDaoImpl().delete(id);
    }
}
