package com.shevchuk.dao.implementation;

import com.shevchuk.model.AdressEntity;

public class AdressDao extends GeneralDaoImpl<AdressEntity, Integer> {
    public AdressDao() {
        super(AdressEntity.class);
    }
}
