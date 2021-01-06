package com.shevchuk.controller;

import com.shevchuk.domain.Doctor;
import com.shevchuk.service.DoctorService;
import com.shevchuk.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController extends GeneralController<Doctor> {

  @Autowired
  DoctorService doctorService;

  @Override
  public ServiceInterface<Doctor> getService() {
    return doctorService;
  }

}
