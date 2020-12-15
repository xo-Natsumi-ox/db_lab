package com.shevchuk.controller.implementation;

import com.shevchuk.model.SheduleEntity;
import com.shevchuk.service.GeneralService;
import com.shevchuk.service.implementation.SheduleService;

public class SheduleController
        extends GeneralControllerImpl<SheduleEntity, Integer> {
    GeneralService<SheduleEntity, Integer> shedule = new SheduleService();

    @Override
    public GeneralService<SheduleEntity, Integer> getService() {
        return shedule;
    }
}
