package com.shevchuk.controller.implementation;

import com.shevchuk.model.PatientEntity;
import com.shevchuk.service.GeneralService;
import com.shevchuk.service.implementation.PatientService;

public class PatientController
        extends GeneralControllerImpl<PatientEntity, Integer> {
    GeneralService<PatientEntity, Integer> patient = new PatientService();

    @Override
    public GeneralService<PatientEntity, Integer> getService() {
        return patient;
    }
}
