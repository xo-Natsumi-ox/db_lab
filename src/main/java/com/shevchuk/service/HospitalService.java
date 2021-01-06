package com.shevchuk.service;

import com.shevchuk.domain.Hospital;
import com.shevchuk.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalService extends GeneralService<Hospital> {

  @Autowired
  HospitalRepository hospitalRepository;

  @Override
  public JpaRepository<Hospital, Integer> getRepository() {
    return hospitalRepository;
  }

}
