package com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.FlightDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.model.Flight;

@Component
public class DTOFlightConverter
{
	
	@Autowired
	DTOAvioCompanyConverter companyConverter;
	
	public FlightDTO convertToDTO(Flight bean)
	{
		FlightDTO dto = new FlightDTO();
		
		dto.setFlightTime(bean.getTravelingTime());
		dto.setFlightLength(bean.getTravelingDistance());
		dto.setLandingTime(bean.getLandingDate());
		dto.setNumberOfTransfers(bean.getNumberOfTransfers());
		dto.setTakeOffTime(bean.getTakeOffDate());
		dto.setCompany(companyConverter.convertToDTO(bean.getCompanyId())); //(OK?)!
		dto.setId(bean.getId());
		
		return dto;
		
	}
	
	public Flight convertFromDTO(FlightDTO dto)
	{
		Flight bean = new Flight();
		
		bean.setTravelingTime(dto.getFlightTime());
		bean.setTravelingDistance(dto.getFlightLength());
		bean.setLandingDate(dto.getLandingTime());
		bean.setNumberOfTransfers(dto.getNumberOfTransfers());
		bean.setTakeOffDate(dto.getTakeOffTime());
		bean.setCompanyId(companyConverter.convertFromDTO(dto.getCompany())); //(OK?)!
		bean.setId(dto.getId());
		
		return bean;
	}
	
}
