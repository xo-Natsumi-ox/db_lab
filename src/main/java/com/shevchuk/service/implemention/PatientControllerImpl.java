package com.shevchuk.service.implemention;

import com.shevchuk.dao.implementation.PatientDaoImpl;
import com.shevchuk.model.PatientEntity;
import com.shevchuk.service.PatientController;

import java.util.List;

public class PatientControllerImpl implements PatientController {
    @Override
    public List<PatientEntity> getAll() {
        return new PatientDaoImpl().findAll();
    }

    @Override
    public PatientEntity getById(Integer id) {
        return new PatientDaoImpl().findById(id);
    }

    @Override
    public void create(PatientEntity entity) {
        new PatientDaoImpl().create(entity);
    }

    @Override
    public void update(PatientEntity entity) {
        new PatientDaoImpl().update(entity);
    }

    @Override
    public void delete(Integer id) {
        new PatientDaoImpl().delete(id);
    }
}
