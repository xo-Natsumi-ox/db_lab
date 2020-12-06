package com.shevchuk.service.implemention;

import com.shevchuk.dao.implementation.SheduleDaoImpl;
import com.shevchuk.model.SheduleEntity;
import com.shevchuk.service.SheduleController;

import java.util.List;

public class SheduleControllerImpl implements SheduleController {
    @Override
    public List<SheduleEntity> getAll() {
        return new SheduleDaoImpl().findAll();
    }

    @Override
    public SheduleEntity getById(Integer id) {
        return new SheduleDaoImpl().findById(id);
    }

    @Override
    public void create(SheduleEntity entity) {
        new SheduleDaoImpl().create(entity);
    }

    @Override
    public void update(SheduleEntity entity) {
        new SheduleDaoImpl().update(entity);
    }

    @Override
    public void delete(Integer id) {
        new SheduleDaoImpl().delete(id);
    }
}
