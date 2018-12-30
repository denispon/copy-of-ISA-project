package com.ftn.isa.projekat.hotel.hotelCore.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.TipSobeDTO;
import com.ftn.isa.projekat.hotel.hotelCore.TipSobe.model.TipSobe;

@JsonComponent
@Component
public class DTOTipSobeConverter {

	@Autowired
	DTOVanredneCeneConverter vanredneConverter;
	
	public TipSobeDTO convertToDTO(TipSobe tip) {
		
		TipSobeDTO dto=new TipSobeDTO();	
		dto.setId(tip.getId());
		dto.setNocenjePrice(tip.getNocenjePrice());
		dto.setPansionPrice(tip.getPansionPrice());
		dto.setPolupansionPrice(tip.getPolupansionPrice());
		dto.setRoomType(tip.getRoomType());
		dto.setVanredneCeneNocenja_tipSobe(vanredneConverter.convertToDTO(tip.getVanredneCeneNocenja_tipSobe()));
		return dto;
		
	}
	
	public TipSobe convertFromDTO(TipSobeDTO tipDTO) {
		TipSobe bean=new TipSobe();
		bean.setNocenjePrice(tipDTO.getPansionPrice());
		bean.setPansionPrice(tipDTO.getNocenjePrice());
		bean.setPolupansionPrice(tipDTO.getPolupansionPrice());
		bean.setRoomType(tipDTO.getRoomType());
		bean.setVanredneCeneNocenja_tipSobe(vanredneConverter.convertFromDTO(tipDTO.getVanredneCeneNocenja_tipSobe()));
		return bean;
		
	}
	
}
