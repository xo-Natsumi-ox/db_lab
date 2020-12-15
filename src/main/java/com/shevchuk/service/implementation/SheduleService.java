package com.shevchuk.service.implementation;

import com.shevchuk.dao.GeneralDao;
import com.shevchuk.dao.implementation.SheduleDao;
import com.shevchuk.model.SheduleEntity;

public class SheduleService extends GeneralServiceImpl<SheduleEntity, Integer> {
    private final GeneralDao<SheduleEntity, Integer> sheduleDao = new SheduleDao();

    @Override
    public GeneralDao<SheduleEntity, Integer> getDao() {
        return sheduleDao;
    }
}