package com.shevchuk.service.implemention;

import com.shevchuk.dao.implementation.DoctorDaoImpl;
import com.shevchuk.model.DoctorEntity;
import com.shevchuk.service.DoctorController;

import java.util.List;

public class DoctorControllerImpl implements DoctorController {
    @Override
    public List<DoctorEntity> getAll() {
        return new DoctorDaoImpl().findAll();
    }

    @Override
    public DoctorEntity getById(Integer id) {
        return new DoctorDaoImpl().findById(id);
    }

    @Override
    public void create(DoctorEntity entity) {
        new DoctorDaoImpl().create(entity);
    }

    @Override
    public void update(DoctorEntity entity) {
        new DoctorDaoImpl().update(entity);
    }

    @Override
    public void delete(Integer id) {
        new DoctorDaoImpl().delete(id);
    }
}
