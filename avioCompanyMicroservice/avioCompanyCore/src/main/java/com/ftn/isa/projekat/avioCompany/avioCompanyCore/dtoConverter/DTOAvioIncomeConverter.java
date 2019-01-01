package com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioCompanyDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioIncomeDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.DestinationDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model.AvioCompany;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.model.AvioIncome;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.model.Destination;

@Component
public class DTOAvioIncomeConverter
{

	@Autowired
	private DTOAvioCompanyConverter companyConverter;
	
	@Autowired
	private DTODestinationConverter destinationConverter;
	
	/*
	 * Returns DTO object from regular model object
	 */
	public AvioIncomeDTO convertToDTO(AvioIncome avio)
	{
		AvioIncomeDTO dto = new AvioIncomeDTO();
		
		dto.setDateOfIncome(avio.getIncomeDate());
		dto.setIncome(avio.getIncome());
		dto.setPurchasedTicketsNum(avio.getTicketsNumber());
		dto.setCompany(companyConverter.convertToDTO(avio.getCompanyId())); //fora je da kod ovih entiteta se pozove konverter iz odgovarajuce klase
		dto.setId(avio.getId());
		
		return dto;
	}

	public AvioIncome convertFromDTO(AvioIncomeDTO dto) 
	{
		AvioIncome bean = new AvioIncome(); //kako mi ovde ne trazi difoltni konstruktor, vec ga nadje preko @Data? wuut
		
		bean.setIncome(dto.getIncome());
		bean.setIncomeDate(dto.getDateOfIncome());
		bean.setTicketsNumber(dto.getPurchasedTicketsNum());
		bean.setCompanyId(companyConverter.convertFromDTO(dto.getCompany()));
		bean.setId(dto.getId());
		
		return bean;
	}

}
