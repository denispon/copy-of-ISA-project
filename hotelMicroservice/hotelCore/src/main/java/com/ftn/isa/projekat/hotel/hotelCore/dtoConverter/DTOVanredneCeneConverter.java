package com.ftn.isa.projekat.hotel.hotelCore.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelskaSobaDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.VanredneCeneNocenjaDTO;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.service.HotelService;
import com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.model.HotelskaSoba;
import com.ftn.isa.projekat.hotel.hotelCore.VanredneCeneNocenja.model.VanredneCeneNocenja;

@Component
public class DTOVanredneCeneConverter {
	
	@Autowired
	DTOHotelConverter hotelConverter;
	
	public VanredneCeneNocenjaDTO convertToDTO(VanredneCeneNocenja cena) {
		VanredneCeneNocenjaDTO dto=new VanredneCeneNocenjaDTO();	
		dto.setId(cena.getId());
		dto.setDateFrom(cena.getDateFrom());
		dto.setDateUntil(cena.getDateUntil());
		dto.setIsItCheaper(cena.getIsItCheaper());
		dto.setPriceChange(cena.getPriceChange());
		dto.setHotel(hotelConverter.convertToDTO(cena.getHotel_vandredneCeneNocenja()));
		return dto;
		
	}
	
	public VanredneCeneNocenja convertFromDTO(VanredneCeneNocenjaDTO cenaDTO) {
		VanredneCeneNocenja bean=new VanredneCeneNocenja();
		bean.setDateFrom(cenaDTO.getDateFrom());
		bean.setDateUntil(cenaDTO.getDateUntil());
		bean.setIsItCheaper(cenaDTO.getIsItCheaper());
		bean.setPriceChange(cenaDTO.getPriceChange());
		bean.setHotel_vandredneCeneNocenja(hotelConverter.convertFromDTO(cenaDTO.getHotel()));

		return bean;
		
	}

}
