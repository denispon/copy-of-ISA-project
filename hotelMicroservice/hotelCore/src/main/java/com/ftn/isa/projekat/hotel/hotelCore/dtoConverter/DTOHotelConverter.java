package com.ftn.isa.projekat.hotel.hotelCore.dtoConverter;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelDTO;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.model.Hotel;

@JsonComponent
@Component
public class DTOHotelConverter {
	public HotelDTO convertToDTO(Hotel hotel) {
		
		HotelDTO dto=new HotelDTO();	
		dto.setId(hotel.getId());
		dto.setName(hotel.getName());
		dto.setAdress(hotel.getAdress());
		dto.setPromotionalDescription(hotel.getPromotionalDescription());
		return dto;
		
	}
	
	public Hotel convertFromDTO(HotelDTO hotelDTO) {
		Hotel bean=new Hotel();
		bean.setName(hotelDTO.getName());
		bean.setAdress(hotelDTO.getAdress());
		bean.setPromotionalDescription(hotelDTO.getPromotionalDescription());
		return bean;
		
	}
}
