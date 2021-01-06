package com.shevchuk.controller;

import com.shevchuk.domain.Patient;
import com.shevchuk.service.PatientService;
import com.shevchuk.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController extends GeneralController<Patient> {

  @Autowired
  PatientService patientService;

  @Override
  public ServiceInterface<Patient> getService() {
    return patientService;
  }

}
