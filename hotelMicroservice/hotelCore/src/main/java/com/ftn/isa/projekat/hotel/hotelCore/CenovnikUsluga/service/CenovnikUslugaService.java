package com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.CenovnikUslugaDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelskaSobaDTO;
import com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.model.CenovnikUsluga;
import com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.repository.CenovnikUslugaRepository;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.repository.HotelRepository;
import com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.model.HotelskaSoba;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOCenovnikConverter;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOHotelConverter;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOHotelskaSobaConverter;

@Component
public class CenovnikUslugaService implements ICenovnikUslugaService{
	
	@Autowired
	DTOHotelConverter hotelConverter;
	
	@Autowired
	DTOCenovnikConverter cenovnikConverter;
	
	@Autowired
	CenovnikUslugaRepository cenovnikRepository;
	
	@Autowired
	HotelRepository hotelRepository;
	
	public CenovnikUslugaDTO findOneById(Long id) {
		
		Optional<CenovnikUsluga> zaPronalazak=cenovnikRepository.findById(id);
		
		if(zaPronalazak.isPresent()) {
			return cenovnikConverter.convertToDTO(zaPronalazak.get());
		}else {
			return new CenovnikUslugaDTO();
		}		
	}
	
	public List<CenovnikUslugaDTO> findAll(){
		Optional<List<CenovnikUsluga>> list = Optional.of(cenovnikRepository.findAll());
		ArrayList<CenovnikUslugaDTO> arrayDTO = new ArrayList<CenovnikUslugaDTO>();
		if(list.isPresent()) {
			for(CenovnikUsluga item : list.get()) {
				arrayDTO.add(cenovnikConverter.convertToDTO(item));
			}
			return arrayDTO;
		}
		return Collections.emptyList();
	}
	
	public CenovnikUslugaDTO save(CenovnikUslugaDTO dto) {
		cenovnikRepository.save(cenovnikConverter.convertFromDTO(dto));
		return dto;
	}
	
	public CenovnikUslugaDTO deleteById(Long id) {
		
		Optional<CenovnikUsluga> zaBrisanje = cenovnikRepository.findById(id);
		
		if(zaBrisanje.isPresent()) {
			cenovnikRepository.deleteById(id);
			return cenovnikConverter.convertToDTO(zaBrisanje.get());
		}else {
			return new CenovnikUslugaDTO();
		}
		
	}
	
	public CenovnikUslugaDTO change(Long id, CenovnikUslugaDTO dto) {
		
		Optional<CenovnikUsluga> zaIzmenu = cenovnikRepository.findById(id);
		
		if(zaIzmenu.isPresent() && dto!=null) {
			
			zaIzmenu.get().setTransferPrice(dto.getTransferPrice());
			zaIzmenu.get().setHotel_cenovnikUsluga(hotelConverter.convertFromDTO(dto.getHotel_cenovnikUsluga()));

			cenovnikRepository.save(zaIzmenu.get());
			
			dto.setId(zaIzmenu.get().getId());
			
			return dto;
		}
		
		return new CenovnikUslugaDTO();
		
	}
	
}
