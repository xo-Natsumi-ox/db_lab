package com.shevchuk.service.implementation;

import com.shevchuk.dao.implementation.AdressDao;
import com.shevchuk.model.AdressEntity;

public class AdressService
        extends GeneralServiceImpl<AdressEntity, Integer, AdressDao> {
    public AdressService() {
        super(AdressDao.class);
    }
}
