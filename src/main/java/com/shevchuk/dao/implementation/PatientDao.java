package com.shevchuk.dao.implementation;

import com.shevchuk.model.PatientEntity;

public class PatientDao extends GeneralDaoImpl<PatientEntity, Integer> {
    public Class<PatientEntity> getObjClass() {
        return PatientEntity.class;
    }
}