package com.shevchuk.service.implemention;

import com.shevchuk.dao.implementation.HospitalDaoImpl;
import com.shevchuk.model.HospitalEntity;
import com.shevchuk.service.HospitalService;

import java.sql.SQLException;
import java.util.List;

public final class HospitalServiceImpl implements HospitalService {
    @Override
    public List<HospitalEntity> getAll() throws SQLException {
        return new HospitalDaoImpl().findAll();
    }

    @Override
    public HospitalEntity getById(Integer id) throws SQLException {
        return new HospitalDaoImpl().findById(id);
    }

    @Override
    public int create(HospitalEntity entity) throws SQLException {
        return new HospitalDaoImpl().create(entity);
    }

    @Override
    public int update(HospitalEntity entity) throws SQLException {
        return new HospitalDaoImpl().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return new HospitalDaoImpl().delete(id);
    }
}
