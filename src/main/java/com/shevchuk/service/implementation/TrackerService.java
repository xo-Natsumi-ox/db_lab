package com.shevchuk.service.implementation;

import com.shevchuk.dao.GeneralDao;
import com.shevchuk.dao.implementation.TrackerDao;
import com.shevchuk.model.TrackerEntity;

public class TrackerService extends GeneralServiceImpl<TrackerEntity, Integer> {
    private final GeneralDao<TrackerEntity, Integer> trackerDao = new TrackerDao();

    @Override
    public GeneralDao<TrackerEntity, Integer> getDao() {
        return trackerDao;
    }
}