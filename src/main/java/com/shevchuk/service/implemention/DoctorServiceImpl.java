package com.shevchuk.service.implemention;

import com.shevchuk.dao.implementation.DoctorDaoImpl;
import com.shevchuk.model.DoctorEntity;
import com.shevchuk.service.DoctorService;

import java.sql.SQLException;
import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    @Override
    public List<DoctorEntity> getAll() throws SQLException {
        return new DoctorDaoImpl().findAll();
    }

    @Override
    public DoctorEntity getById(Integer id) throws SQLException {
        return new DoctorDaoImpl().findById(id);
    }

    @Override
    public int create(DoctorEntity entity) throws SQLException {
        return new DoctorDaoImpl().create(entity);
    }

    @Override
    public int update(DoctorEntity entity) throws SQLException {
        return new DoctorDaoImpl().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return new DoctorDaoImpl().delete(id);
    }
}
