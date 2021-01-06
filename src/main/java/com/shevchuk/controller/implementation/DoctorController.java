package com.shevchuk.controller.implementation;

import com.shevchuk.model.DoctorEntity;
import com.shevchuk.service.implementation.DoctorService;

public class DoctorController
        extends GeneralControllerImpl<DoctorEntity, Integer, DoctorService> {
    public DoctorController() {
        super(DoctorService.class);
    }
}
