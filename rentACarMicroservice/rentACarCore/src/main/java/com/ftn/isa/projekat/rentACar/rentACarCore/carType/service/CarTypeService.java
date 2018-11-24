package com.ftn.isa.projekat.rentACar.rentACarCore.carType.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.rentACar.rentACarCore.carType.repository.CarTypeRepository;

@Service
public class CarTypeService {

	@Autowired
	CarTypeRepository carTypeRepository;
}
