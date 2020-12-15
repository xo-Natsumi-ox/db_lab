package com.shevchuk.dao.implementation;

import com.shevchuk.model.AdressEntity;

public class AdressDao extends GeneralDaoImpl<AdressEntity, Integer> {
    public Class<AdressEntity> getObjClass() {
        return AdressEntity.class;
    }
}