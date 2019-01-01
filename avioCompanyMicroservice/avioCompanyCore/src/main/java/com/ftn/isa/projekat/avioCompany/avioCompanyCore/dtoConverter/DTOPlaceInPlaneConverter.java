package com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.PlaceInPlaneDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.PlaceInPlane.model.PlaceInPlane;

@Component
public class DTOPlaceInPlaneConverter
{
	public PlaceInPlane convertFromDto(PlaceInPlaneDTO dto)
	{
		PlaceInPlane place = new PlaceInPlane();
		
		place.setId(dto.getId());
		place.setOccupied(dto.isReserved());
		place.setSerialNumber(dto.getSerialNum());
		
		return place;
	}
	
	public PlaceInPlaneDTO convertToDto(PlaceInPlane bean)
	{
		PlaceInPlaneDTO dto = new PlaceInPlaneDTO();
		
		dto.setId(bean.getId());
		dto.setReserved(bean.isOccupied());
		dto.setSerialNum(bean.getSerialNumber());
		
		return dto;
	}
}
