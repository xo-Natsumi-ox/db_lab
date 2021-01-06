package com.shevchuk.service.implementation;

import com.shevchuk.dao.implementation.DoctorDao;
import com.shevchuk.model.DoctorEntity;

public class DoctorService
        extends GeneralServiceImpl<DoctorEntity, Integer, DoctorDao> {
    public DoctorService() {
        super(DoctorDao.class);
    }
}
