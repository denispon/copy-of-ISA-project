package com.ftn.isa.projekat.rentACar.rentACarCore.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.rentACar.rentACarCore.car.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	CarRepository carRepository;
}
