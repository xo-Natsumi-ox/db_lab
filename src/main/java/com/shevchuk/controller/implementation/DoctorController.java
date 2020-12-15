package com.shevchuk.controller.implementation;

import com.shevchuk.model.DoctorEntity;
import com.shevchuk.service.GeneralService;
import com.shevchuk.service.implementation.DoctorService;

public class DoctorController
        extends GeneralControllerImpl<DoctorEntity, Integer> {
    GeneralService<DoctorEntity, Integer> doctor = new DoctorService();

    @Override
    public GeneralService<DoctorEntity, Integer> getService() {
        return doctor;
    }
}
