package com.shevchuk.controller.implementation;

import com.shevchuk.model.PatientEntity;
import com.shevchuk.service.implementation.PatientService;

public class PatientController
        extends GeneralControllerImpl<PatientEntity, Integer, PatientService> {
    public PatientController() {
        super(PatientService.class);
    }
}
