package com.shevchuk.service.implementation;

import com.shevchuk.dao.implementation.HospitalDao;
import com.shevchuk.model.HospitalEntity;

public class HospitalService
        extends GeneralServiceImpl<HospitalEntity, Integer, HospitalDao> {
    public HospitalService() {
        super(HospitalDao.class);
    }
}
