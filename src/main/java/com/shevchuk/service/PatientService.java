package com.shevchuk.service;

import com.shevchuk.domain.Patient;
import com.shevchuk.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends GeneralService<Patient> {

  @Autowired
  PatientRepository patientRepository;

  @Override
  public JpaRepository<Patient, Integer> getRepository() {
    return patientRepository;
  }

}
