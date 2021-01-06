package com.shevchuk.service.implementation;

import com.shevchuk.dao.implementation.PatientDao;
import com.shevchuk.model.PatientEntity;

public class PatientService
        extends GeneralServiceImpl<PatientEntity, Integer, PatientDao> {
    public PatientService() {
        super(PatientDao.class);
    }
}
