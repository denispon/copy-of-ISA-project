package com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.DestinationDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.model.Destination;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.repository.DestinationRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.controller.FlightController;

@Component
public class DTODestinationConverter
{
	@Autowired
	private DestinationRepository destRepository;
	
	@Autowired 
	private DTOFlightConverter flightConverter;
	
	@Autowired
	private DTOAvioCompanyConverter avioConverter;
	
	
	
	public DestinationDTO convertToDto(Destination dest)
	{
		DestinationDTO dto = new DestinationDTO();
		
		dto.setId(dest.getId());
		dto.setName(dest.getName());
		//dto.setAvioCompany(avioConverter.convertToDTO(dest.getAvioCompany()));
		//dto.setFlightTakeOff(flightConverter.convertToDTO(dest.getFlightTakeOff()));
		//dto.setFlightLanding(flightConverter.convertToDTO(dest.getFlightLanding()));
		
		return dto;
	}

	public Object convertFromDTO(DestinationDTO dto)
	{
		Optional<Destination> destination = destRepository.findById(dto.getId());
		
		if(destination.isPresent())
		{
			return destination.get();
		}
		
		Destination dest = new Destination();
		
		dest.setId(dto.getId());
		dest.setName(dto.getName());
		//dest.setAvioCompany(avioConverter.convertFromDTO(dto.getAvioCompany()));
		//dest.setFlightTakeOff(flightConverter.convertFromDTO(dto.getFlightTakeOff()));
		//dest.setFlightLanding(flightConverter.convertFromDTO(dto.getFlightLanding()));
		
		return dest;
	}

}
