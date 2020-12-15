package com.shevchuk.controller.implementation;

import com.shevchuk.model.HospitalEntity;
import com.shevchuk.service.GeneralService;
import com.shevchuk.service.implementation.HospitalService;

public class HospitalController
        extends GeneralControllerImpl<HospitalEntity, Integer> {
    GeneralService<HospitalEntity, Integer> hospital = new HospitalService();

    @Override
    public GeneralService<HospitalEntity, Integer> getService() {
        return hospital;
    }
}
