package com.shevchuk.service.implementation;

import com.shevchuk.dao.GeneralDao;
import com.shevchuk.dao.implementation.AdressDao;
import com.shevchuk.model.AdressEntity;

public class AdressService extends GeneralServiceImpl<AdressEntity, Integer> {
    private final GeneralDao<AdressEntity, Integer> adressDao = new AdressDao();

    @Override
    public GeneralDao<AdressEntity, Integer> getDao() {
        return adressDao;
    }
}