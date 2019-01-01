package com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioCompanyDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.DestinationDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model.AvioCompany;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.model.Destination;

@Component
public class DTOAvioCompanyConverter 
{

	@Autowired
	private DTOAvioCompanyConverter companyConverter;
	
	@Autowired
	private DTODestinationConverter destinationConverter;
	
	/*
	 * Returns DTO object from regular model object
	 */
	public AvioCompanyDTO convertToDTO(AvioCompany avio)
	{
		AvioCompanyDTO dto = new AvioCompanyDTO();
		
		dto.setAddress(avio.getAddress());
		dto.setId(avio.getId());
		dto.setName(avio.getName());
		dto.setDescription(avio.getDescription());
		
		return dto;
	}

	public AvioCompany convertFromDTO(AvioCompanyDTO dto) //nz jel gotova metoda
	{
		AvioCompany bean = new AvioCompany();
		
		bean.setAddress(dto.getAddress());
		bean.setDescription(dto.getDescription());
		bean.setName(dto.getName());
		
		return bean;
	}

}

















