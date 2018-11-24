package com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.repository.RentACarServiceRepository;

@Service
public class rentACarServiceService {

	@Autowired
	RentACarServiceRepository rentACarServiceRepository;
}
