package com.shevchuk.dao.implementation;

import com.shevchuk.model.DoctorEntity;

public class DoctorDao extends GeneralDaoImpl<DoctorEntity, Integer> {
    public DoctorDao() {
        super(DoctorEntity.class);
    }
}
