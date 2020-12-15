package com.shevchuk.service.implemention;

import com.shevchuk.dao.implementation.HospitalDaoImpl;
import com.shevchuk.model.HospitalEntity;
import com.shevchuk.service.HospitalController;

import java.util.List;

public class HospitalControllerImpl implements HospitalController {
    @Override
    public List<HospitalEntity> getAll() {
        return new HospitalDaoImpl().findAll();
    }

    @Override
    public HospitalEntity getById(Integer id) {
        return new HospitalDaoImpl().findById(id);
    }

    @Override
    public void create(HospitalEntity entity) {
        new HospitalDaoImpl().create(entity);
    }

    @Override
    public void update(HospitalEntity entity) {
        new HospitalDaoImpl().update(entity);
    }

    @Override
    public void delete(Integer id) {
        new HospitalDaoImpl().delete(id);
    }
}
