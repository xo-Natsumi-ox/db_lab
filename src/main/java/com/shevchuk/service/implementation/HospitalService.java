package com.shevchuk.service.implementation;

import com.shevchuk.dao.GeneralDao;
import com.shevchuk.dao.implementation.HospitalDao;
import com.shevchuk.model.HospitalEntity;

public class HospitalService extends GeneralServiceImpl<HospitalEntity, Integer> {
    private final GeneralDao<HospitalEntity, Integer> hospitalDao = new HospitalDao();

    @Override
    public GeneralDao<HospitalEntity, Integer> getDao() {
        return hospitalDao;
    }
}
