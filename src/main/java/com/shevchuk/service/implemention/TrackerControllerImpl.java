package com.shevchuk.service.implemention;

import com.shevchuk.dao.implementation.TrackerDaoImpl;
import com.shevchuk.model.TrackerEntity;
import com.shevchuk.service.TrackerController;

import java.util.List;

public class TrackerControllerImpl implements TrackerController {
    @Override
    public List<TrackerEntity> getAll() {
        return new TrackerDaoImpl().findAll();
    }

    @Override
    public TrackerEntity getById(Integer id) {
        return new TrackerDaoImpl().findById(id);
    }

    @Override
    public void create(TrackerEntity entity) {
        new TrackerDaoImpl().create(entity);
    }

    @Override
    public void update(TrackerEntity entity) {
        new TrackerDaoImpl().update(entity);
    }

    @Override
    public void delete(Integer id) {
        new TrackerDaoImpl().delete(id);
    }
}
