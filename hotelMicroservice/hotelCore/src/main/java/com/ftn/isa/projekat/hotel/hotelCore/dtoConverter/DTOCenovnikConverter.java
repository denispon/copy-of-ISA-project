package com.ftn.isa.projekat.hotel.hotelCore.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.CenovnikUslugaDTO;
import com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.model.CenovnikUsluga;

@JsonComponent
@Component
public class DTOCenovnikConverter {
	
	@Autowired
	DTOHotelConverter hotelConverter;
	
	public CenovnikUslugaDTO convertToDTO(CenovnikUsluga cenovnikUsluga) {
		CenovnikUslugaDTO dto = new CenovnikUslugaDTO();
		dto.setId(cenovnikUsluga.getId());
		dto.setHotel_cenovnikUsluga(hotelConverter.convertToDTO(cenovnikUsluga.getHotel_cenovnikUsluga()));
		dto.setTransferPrice(cenovnikUsluga.getTransferPrice());
		
		return dto;
	}
	
	public CenovnikUsluga convertFromDTO(CenovnikUslugaDTO cenovnikUslugaDTO) {
		
		CenovnikUsluga bean = new CenovnikUsluga();
		bean.setTransferPrice(cenovnikUslugaDTO.getTransferPrice());
		bean.setHotel_cenovnikUsluga(hotelConverter.convertFromDTO(cenovnikUslugaDTO.getHotel_cenovnikUsluga()));
		
		return bean;
		
	}

}
