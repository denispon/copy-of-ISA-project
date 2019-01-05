package com.ftn.isa.projekat.hotel.hotelCore.dtoConverter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.CenovnikUslugaDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.DodatneUslugeDTO;
import com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.model.CenovnikUsluga;
import com.ftn.isa.projekat.hotel.hotelCore.DodatneUsluge.model.DodatneUsluge;
import com.ftn.isa.projekat.hotel.hotelCore.DodatneUsluge.repository.DodatneUslugeRepository;

@JsonComponent
@Component
public class DTODodatneUslugeConverter {

	@Autowired
	DTOCenovnikConverter cenovnikConverter;
	
	@Autowired
	DodatneUslugeRepository dodatneUslugeRepository;
	
	public DodatneUslugeDTO convertToDTO(DodatneUsluge dodatneUsluge) {
		DodatneUslugeDTO dto = new DodatneUslugeDTO();
		dto.setId(dodatneUsluge.getId());
		dto.setAdditionalServiceName(dodatneUsluge.getAdditionalServiceName());
		dto.setAdditionalServicePrice(dto.getAdditionalServicePrice());
		dto.setCenovnikUsluga_dodatneUsluge(cenovnikConverter.convertToDTO(dodatneUsluge.getCenovnikUsluga_dodatneUsluge()));
		
		return dto;
	}
	
	public DodatneUsluge convertFromDTO(DodatneUslugeDTO dodatneUslugeDTO) {
		
		Optional<DodatneUsluge> dodatneUsluge = dodatneUslugeRepository.findById(dodatneUslugeDTO.getId());
		if(dodatneUsluge.isPresent()) {
			return dodatneUsluge.get();
		}
		
		DodatneUsluge bean = new DodatneUsluge();
		bean.setAdditionalServiceName(dodatneUslugeDTO.getAdditionalServiceName());
		bean.setAdditionalServicePrice(dodatneUslugeDTO.getAdditionalServicePrice());
		bean.setCenovnikUsluga_dodatneUsluge(cenovnikConverter.convertFromDTO(dodatneUslugeDTO.getCenovnikUsluga_dodatneUsluge()));
		
		return bean;
		
	}
	
	
	
}
