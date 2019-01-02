package com.ftn.isa.projekat.hotel.hotelCore.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.CenovnikUslugaDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.DodatneUslugeDTO;
import com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.model.CenovnikUsluga;
import com.ftn.isa.projekat.hotel.hotelCore.DodatneUsluge.model.DodatneUsluge;

@JsonComponent
@Component
public class DTODodatneUslugeConverter {

	@Autowired
	DTOCenovnikConverter cenovnikConverter;
	
	public DodatneUslugeDTO convertToDTO(DodatneUsluge dodatneUsluge) {
		DodatneUslugeDTO dto = new DodatneUslugeDTO();
		dto.setId(dodatneUsluge.getId());
		dto.setAdditionalServiceName(dodatneUsluge.getAdditionalServiceName());
		dto.setAdditionalServicePrice(dto.getAdditionalServicePrice());
		dto.setCenovnikUsluga_dodatneUsluge(cenovnikConverter.convertToDTO(dodatneUsluge.getCenovnikUsluga_dodatneUsluge()));
		
		return dto;
	}
	
	public DodatneUsluge convertFromDTO(DodatneUslugeDTO dodatneUslugeDTO) {
		
		DodatneUsluge bean = new DodatneUsluge();
		bean.setAdditionalServiceName(dodatneUslugeDTO.getAdditionalServiceName());
		bean.setAdditionalServicePrice(dodatneUslugeDTO.getAdditionalServicePrice());
		bean.setCenovnikUsluga_dodatneUsluge(cenovnikConverter.convertFromDTO(dodatneUslugeDTO.getCenovnikUsluga_dodatneUsluge()));
		
		return bean;
		
	}
	
	
	
}
