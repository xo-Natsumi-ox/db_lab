package com.shevchuk.service.implementation;

import com.shevchuk.dao.GeneralDao;
import com.shevchuk.dao.implementation.PatientDao;
import com.shevchuk.model.PatientEntity;

public class PatientService extends GeneralServiceImpl<PatientEntity, Integer> {
    private final GeneralDao<PatientEntity, Integer> patientDao = new PatientDao();

    @Override
    public GeneralDao<PatientEntity, Integer> getDao() {
        return patientDao;
    }
}