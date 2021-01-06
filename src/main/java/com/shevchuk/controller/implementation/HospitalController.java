package com.shevchuk.controller.implementation;

import com.shevchuk.model.HospitalEntity;
import com.shevchuk.service.implementation.HospitalService;

public class HospitalController extends GeneralControllerImpl
        <HospitalEntity, Integer, HospitalService> {
    public HospitalController() {
        super(HospitalService.class);
    }
}
