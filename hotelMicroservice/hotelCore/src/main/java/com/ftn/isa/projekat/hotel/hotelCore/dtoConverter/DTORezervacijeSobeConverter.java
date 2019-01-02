package com.ftn.isa.projekat.hotel.hotelCore.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.CenovnikUslugaDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.RezervacijeSobeDTO;
import com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.model.CenovnikUsluga;
import com.ftn.isa.projekat.hotel.hotelCore.RezervacijeSobe.model.RezervacijeSobe;

@JsonComponent
@Component
public class DTORezervacijeSobeConverter {
	
	@Autowired
	DTOHotelskaSobaConverter hotelskaSobaConverter;
	
	public RezervacijeSobeDTO convertToDTO(RezervacijeSobe rezervacijeSobe) {
		RezervacijeSobeDTO dto = new RezervacijeSobeDTO();
		dto.setId(rezervacijeSobe.getId());
		dto.setDateFrom(rezervacijeSobe.getDateFrom());
		dto.setDateUntil(rezervacijeSobe.getDateUntil());
		dto.setRating(rezervacijeSobe.getRating());
		dto.setTotalPrice(rezervacijeSobe.getTotalPrice());
		dto.setHotelskaSoba_rezervacijeSobe(hotelskaSobaConverter.convertToDTO(rezervacijeSobe.getHotelskaSoba_rezervacijeSobe()));	
		
		return dto;
	}
	
	public RezervacijeSobe convertFromDTO(RezervacijeSobeDTO rezervacijeSobeDTO) {
		
		RezervacijeSobe bean = new RezervacijeSobe();
		bean.setDateFrom(rezervacijeSobeDTO.getDateFrom());
		bean.setDateUntil(rezervacijeSobeDTO.getDateUntil());
		bean.setRating(rezervacijeSobeDTO.getRating());
		bean.setTotalPrice(rezervacijeSobeDTO.getTotalPrice());
		bean.setHotelskaSoba_rezervacijeSobe(hotelskaSobaConverter.convertFromDTO(rezervacijeSobeDTO.getHotelskaSoba_rezervacijeSobe()));
		
		
		return bean;
		
	}
	
}
