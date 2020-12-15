package com.shevchuk.controller.implementation;

import com.shevchuk.model.AdressEntity;
import com.shevchuk.service.GeneralService;
import com.shevchuk.service.implementation.AdressService;


public class AdressController
        extends GeneralControllerImpl<AdressEntity, Integer> {
    GeneralService<AdressEntity, Integer> adress = new AdressService();

    @Override
    public GeneralService<AdressEntity, Integer> getService() {
        return adress;
    }
}