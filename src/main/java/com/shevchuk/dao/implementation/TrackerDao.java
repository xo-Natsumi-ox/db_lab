package com.shevchuk.dao.implementation;

import com.shevchuk.model.TrackerEntity;

public class TrackerDao extends GeneralDaoImpl<TrackerEntity, Integer> {
    public Class<TrackerEntity> getObjClass() {
        return TrackerEntity.class;
    }
}