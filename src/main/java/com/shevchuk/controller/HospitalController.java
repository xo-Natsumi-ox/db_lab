package com.shevchuk.controller;

import com.shevchuk.domain.Hospital;
import com.shevchuk.service.HospitalService;
import com.shevchuk.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospital")
public class HospitalController extends GeneralController<Hospital> {

  @Autowired
  HospitalService hospitalService;

  @Override
  public ServiceInterface<Hospital> getService() {
    return hospitalService;
  }

}
