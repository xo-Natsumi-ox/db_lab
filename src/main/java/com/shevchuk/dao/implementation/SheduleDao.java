package com.shevchuk.dao.implementation;

import com.shevchuk.model.SheduleEntity;

public class SheduleDao extends GeneralDaoImpl<SheduleEntity, Integer> {
    public Class<SheduleEntity> getObjClass() {
        return SheduleEntity.class;
    }
}