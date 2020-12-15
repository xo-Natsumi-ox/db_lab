package com.shevchuk.service.implementation;

import com.shevchuk.dao.GeneralDao;
import com.shevchuk.dao.implementation.DoctorDao;
import com.shevchuk.model.DoctorEntity;

public class DoctorService extends GeneralServiceImpl<DoctorEntity, Integer> {
    private final GeneralDao<DoctorEntity, Integer> doctorDao = new DoctorDao();

    @Override
    public GeneralDao<DoctorEntity, Integer> getDao() {
        return doctorDao;
    }
}