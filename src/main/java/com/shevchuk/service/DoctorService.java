package com.shevchuk.service;

import com.shevchuk.domain.Doctor;
import com.shevchuk.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends GeneralService<Doctor> {

  @Autowired
  DoctorRepository doctorRepository;

  @Override
  public JpaRepository<Doctor, Integer> getRepository() {
    return doctorRepository;
  }

}
