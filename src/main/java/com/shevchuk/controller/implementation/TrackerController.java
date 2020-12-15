package com.shevchuk.controller.implementation;

import com.shevchuk.model.TrackerEntity;
import com.shevchuk.service.GeneralService;
import com.shevchuk.service.implementation.TrackerService;

public class TrackerController
        extends GeneralControllerImpl<TrackerEntity, Integer> {
    GeneralService<TrackerEntity, Integer> tracker = new TrackerService();

    @Override
    public GeneralService<TrackerEntity, Integer> getService() {
        return tracker;
    }
}
