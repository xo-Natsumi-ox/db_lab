package com.shevchuk.dao.implementation;

import com.shevchuk.model.DoctorEntity;

public class DoctorDao extends GeneralDaoImpl<DoctorEntity, Integer> {
    public Class<DoctorEntity> getObjClass() {
        return DoctorEntity.class;
    }
}