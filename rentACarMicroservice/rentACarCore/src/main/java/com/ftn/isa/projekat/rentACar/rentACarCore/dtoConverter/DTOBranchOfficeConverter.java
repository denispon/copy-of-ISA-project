package com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.BranchOfficeDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;


public class DTOBranchOfficeConverter {
	
	public BranchOfficeDTO convertToDTO (BranchOffice branchOffice) {
	
		BranchOfficeDTO dto = new BranchOfficeDTO();
	
		dto.setAdress(branchOffice.getAdress());
		dto.setId(branchOffice.getId());
		dto.setName(branchOffice.getName());
		//fali konvertovanje rent A Car Servisa!
		
		
		return dto;
	}
	
	public BranchOffice convertFromDTO ( BranchOfficeDTO branchOfficeDTO ) {
		
		BranchOffice bean = new BranchOffice();	
		
		bean.setAdress(branchOfficeDTO.getAdress());
		bean.setName(branchOfficeDTO.getName());
		//fali konvertovanje rentACar Servisa
		
		return bean;
	}
}
