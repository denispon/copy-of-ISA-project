package com.ftn.isa.projekat.hotel.hotelCore.TipSobe.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.TipSobeDTO;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.model.Hotel;
import com.ftn.isa.projekat.hotel.hotelCore.TipSobe.model.TipSobe;
import com.ftn.isa.projekat.hotel.hotelCore.TipSobe.repository.TipSobeRepository;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOHotelskaSobaConverter;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOTipSobeConverter;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOVanredneCeneConverter;

@Component
public class TipSobeService implements ITipSobeService{
	
	@Autowired
	TipSobeRepository tipSobeRepository;
	
	@Autowired
	DTOVanredneCeneConverter vanredneCeneConverter;
	
	@Autowired
	DTOHotelskaSobaConverter hotelskaSobaConverter;
	
	@Autowired
	DTOTipSobeConverter tipSobeConverter;
	
	public TipSobeDTO findOneById(Long id) {
		
		Optional<TipSobe> tip=tipSobeRepository.findById(id);
		
		if(tip.isPresent()) {
			return tipSobeConverter.convertToDTO(tip.get());
		}else {
			return new TipSobeDTO();
		}
		
	}
	
	public List<TipSobeDTO> findAll(){
		Optional<List<TipSobe>> list = Optional.of(tipSobeRepository.findAll());
		ArrayList<TipSobeDTO> tipoviDTO = new ArrayList<TipSobeDTO>();
		if(list.isPresent()) {
			for(TipSobe tip : list.get()) {
				tipoviDTO.add(tipSobeConverter.convertToDTO(tip));
			}
			return tipoviDTO;
		}
		return Collections.emptyList();
	}
	
	public TipSobeDTO save(TipSobeDTO tipDTO) {
		tipSobeRepository.save(tipSobeConverter.convertFromDTO(tipDTO));
		return tipDTO;
	}
	
	public TipSobeDTO deleteById(Long id) {
		
		Optional<TipSobe> tip = tipSobeRepository.findById(id);
		
		if(tip.isPresent()) {
			tipSobeRepository.deleteById(id);
			return tipSobeConverter.convertToDTO(tip.get());
		}else {
			return null;
		}
		
	}
	
	public TipSobeDTO change(Long id, TipSobeDTO tipDTO) {
		
		Optional<TipSobe> tip = tipSobeRepository.findById(id);
		
		if(tip.isPresent() && tipDTO!=null) {
			tip.get().setNocenjePrice(tipDTO.getNocenjePrice());
			tip.get().setPansionPrice(tipDTO.getPansionPrice());
			tip.get().setPolupansionPrice(tipDTO.getPolupansionPrice());
			tip.get().setRoomType(tipDTO.getRoomType());
			tip.get().setVanredneCeneNocenja_tipSobe(vanredneCeneConverter.convertFromDTO(tipDTO.getVanredneCeneNocenja_tipSobe()));
			
			tipSobeRepository.save(tip.get());
			
			tipDTO.setId(tip.get().getId());
			
			return tipDTO;
		}
		
		return null;
		
	}

}
