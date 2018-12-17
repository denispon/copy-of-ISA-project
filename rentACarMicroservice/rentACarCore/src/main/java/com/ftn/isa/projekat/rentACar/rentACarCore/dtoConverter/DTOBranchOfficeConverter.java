package com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.BranchOfficeDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;

@Component
public class DTOBranchOfficeConverter {
	
	
	
	public BranchOfficeDTO convertToDTO (BranchOffice branchOffice) {
	
		BranchOfficeDTO dto = new BranchOfficeDTO();
	
		
		dto.setAdress(branchOffice.getAdress());
		dto.setId(branchOffice.getId());
		dto.setName(branchOffice.getName());
		
		
		
		
		return dto;
	}
	
	public BranchOffice convertFromDTO ( BranchOfficeDTO branchOfficeDTO ) {
		
		BranchOffice bean = new BranchOffice();	
		
		
		bean.setAdress(branchOfficeDTO.getAdress());
		bean.setName(branchOfficeDTO.getName());
		
	
		
		
		return bean;
	}
}
