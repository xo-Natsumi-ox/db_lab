package com.shevchuk.controller.implementation;

import com.shevchuk.model.AdressEntity;
import com.shevchuk.service.implementation.AdressService;

public class AdressController
        extends GeneralControllerImpl<AdressEntity, Integer, AdressService> {

    public AdressController() {
        super(AdressService.class);
    }
}
