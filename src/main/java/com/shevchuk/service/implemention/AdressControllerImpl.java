package com.shevchuk.service.implemention;

import com.shevchuk.dao.implementation.AdressDaoImpl;
import com.shevchuk.model.AdressEntity;
import com.shevchuk.service.AdressController;

import java.util.List;

public class AdressControllerImpl implements AdressController {
    @Override
    public List<AdressEntity> getAll() {
        return new AdressDaoImpl().findAll();
    }

    @Override
    public AdressEntity getById(Integer id) {
        return new AdressDaoImpl().findById(id);
    }

    @Override
    public void create(AdressEntity entity) {
        new AdressDaoImpl().create(entity);
    }

    @Override
    public void update(AdressEntity entity) {
        new AdressDaoImpl().update(entity);
    }

    @Override
    public void delete(Integer id) {
        new AdressDaoImpl().delete(id);
    }
}
