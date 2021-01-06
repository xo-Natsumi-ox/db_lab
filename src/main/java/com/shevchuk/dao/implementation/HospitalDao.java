package com.shevchuk.dao.implementation;

import com.shevchuk.model.HospitalEntity;

public class HospitalDao extends GeneralDaoImpl<HospitalEntity, Integer> {
    public HospitalDao() {
        super(HospitalEntity.class);
    }
}
