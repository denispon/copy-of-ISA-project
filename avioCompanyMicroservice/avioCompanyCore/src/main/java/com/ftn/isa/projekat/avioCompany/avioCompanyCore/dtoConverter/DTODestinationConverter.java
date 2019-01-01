package com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.DestinationDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.model.Destination;

@Component
public class DTODestinationConverter {

	public DestinationDTO convertToDto(Destination dest)
	{
		DestinationDTO dto = new DestinationDTO();
		
		dto.setStartingPoint(dest.getStartPoint());
		dto.setFinalPoint(dest.getEndPoint());
		dto.setId(dest.getId());
		
		return dto;
	}

	public Object convertFromDTO(DestinationDTO dto)
	{
		Destination dest = new Destination();
		
		dest.setStartPoint(dto.getStartingPoint());
		dest.setEndPoint(dto.getFinalPoint());
		dest.setId(dto.getId());
		
		return dest;
	}

}
