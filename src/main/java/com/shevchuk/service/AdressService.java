package com.shevchuk.service;

import com.shevchuk.domain.Adress;
import com.shevchuk.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AdressService extends GeneralService<Adress> {

  @Autowired
  AdressRepository adressRepository;

  @Override
  public JpaRepository<Adress, Integer> getRepository() {
    return adressRepository;
  }

}
