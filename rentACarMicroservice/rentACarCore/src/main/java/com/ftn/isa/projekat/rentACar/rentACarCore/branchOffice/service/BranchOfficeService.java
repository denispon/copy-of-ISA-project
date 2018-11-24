package com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.repository.BranchOfficeRepository;

@Service
public class BranchOfficeService {

	@Autowired
	BranchOfficeRepository branchOfficeRepository;
	
}
