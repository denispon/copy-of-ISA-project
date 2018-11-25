package com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.BranchOfficeDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;

@Component
public class DTOBranchOfficeConverter {
	
	@Autowired
	private DTORentACarServiceConverter rentACarConverter;
	
	public BranchOfficeDTO convertToDTO (BranchOffice branchOffice) {
	
		BranchOfficeDTO dto = new BranchOfficeDTO();
	
		
		dto.setAdress(branchOffice.getAdress());
		dto.setId(branchOffice.getId());
		dto.setName(branchOffice.getName());
		dto.setService ( rentACarConverter.convertToDTO ( branchOffice.getBranchOfficeService() ) );
		
		
		
		return dto;
	}
	
	public BranchOffice convertFromDTO ( BranchOfficeDTO branchOfficeDTO ) {
		
		BranchOffice bean = new BranchOffice();	
		
		
		bean.setAdress(branchOfficeDTO.getAdress());
		bean.setName(branchOfficeDTO.getName());
		bean.setBranchOfficeService( rentACarConverter.convertFromDTO ( branchOfficeDTO.getService() ) );
	
		
		
		return bean;
	}
}
