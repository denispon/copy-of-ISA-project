package com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelskaSobaDTO;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.model.Hotel;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.repository.HotelRepository;
import com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.model.HotelskaSoba;
import com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.repository.HotelskaSobaRepository;
import com.ftn.isa.projekat.hotel.hotelCore.TipSobe.repository.TipSobeRepository;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOHotelConverter;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOHotelskaSobaConverter;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOTipSobeConverter;

@Component
public class HotelskaSobaService implements IHotelskaSobaService{
	
	@Autowired
	HotelskaSobaRepository hotelskaSobaRepository;
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	TipSobeRepository tipSobeRepository;
	
	@Autowired
	DTOHotelConverter hotelConverter;
	
	@Autowired
    DTOTipSobeConverter tipSobeConverter;
    
	@Autowired
	DTOHotelskaSobaConverter hotelskaSobaConverter;
	
	public HotelskaSobaDTO findOneById(Long id) {
		
		Optional<HotelskaSoba> soba=hotelskaSobaRepository.findById(id);
		
		if(soba.isPresent()) {
			return hotelskaSobaConverter.convertToDTO(soba.get());
		}else {
			return new HotelskaSobaDTO();
		}
		
	}
	
	public List<HotelskaSobaDTO> findAll(){
		Optional<List<HotelskaSoba>> list = Optional.of(hotelskaSobaRepository.findAll());
		ArrayList<HotelskaSobaDTO> sobeDTO = new ArrayList<HotelskaSobaDTO>();
		if(list.isPresent()) {
			for(HotelskaSoba soba : list.get()) {
				sobeDTO.add(hotelskaSobaConverter.convertToDTO(soba));
			}
			return sobeDTO;
		}
		return Collections.emptyList();
	}
	
	public HotelskaSobaDTO save(HotelskaSobaDTO sobaDTO) {
		hotelskaSobaRepository.save(hotelskaSobaConverter.convertFromDTO(sobaDTO));
		return sobaDTO;
	}
	
	public HotelskaSobaDTO deleteById(Long id) {
		
		Optional<HotelskaSoba> soba = hotelskaSobaRepository.findById(id);
		
		if(soba.isPresent()) {
			hotelskaSobaRepository.deleteById(id);
			return hotelskaSobaConverter.convertToDTO(soba.get());
		}else {
			return null;
		}
		
	}
	
	public HotelskaSobaDTO change(Long id, HotelskaSobaDTO sobaDTO) {
		
		Optional<HotelskaSoba> soba = hotelskaSobaRepository.findById(id);
		
		if(soba.isPresent() && sobaDTO!=null) {
			soba.get().setFloor(sobaDTO.getFloor());
			soba.get().setReserved(sobaDTO.getReserved());
			soba.get().setHotel_hotelskeSobe(hotelConverter.convertFromDTO(sobaDTO.getHotel()));
			soba.get().setTipSobe_hotelskeSobe(tipSobeConverter.convertFromDTO(sobaDTO.getTipSobe()));

			hotelskaSobaRepository.save(soba.get());
			
			sobaDTO.setId(soba.get().getId());
			
			return sobaDTO;
		}
		
		return null;
		
	}

}
