package com.ftn.isa.projekat.hotel.hotelCore.RezervacijeSobe.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.CenovnikUslugaDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.RezervacijeSobeDTO;
import com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.model.CenovnikUsluga;
import com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.repository.HotelskaSobaRepository;
import com.ftn.isa.projekat.hotel.hotelCore.RezervacijeSobe.model.RezervacijeSobe;
import com.ftn.isa.projekat.hotel.hotelCore.RezervacijeSobe.repository.RezervacijeSobeRepository;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOHotelskaSobaConverter;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTORezervacijeSobeConverter;

@Component
public class RezervacijeSobeService implements IRezervacijeSobeService{
	
	@Autowired
	RezervacijeSobeRepository rezervacijeSobeRepository;
	
	@Autowired
	DTORezervacijeSobeConverter rezervacijeSobeConverter;
	
	@Autowired
	HotelskaSobaRepository hotelskaSobaRepository;
	
	@Autowired
	DTOHotelskaSobaConverter hotelskaSobaConverter;
	
	public RezervacijeSobeDTO findOneById(Long id) {
		
		Optional<RezervacijeSobe> zaPronalazak=rezervacijeSobeRepository.findById(id);
		
		if(zaPronalazak.isPresent()) {
			return rezervacijeSobeConverter.convertToDTO(zaPronalazak.get());
		}else {
			return new RezervacijeSobeDTO();
		}		
	}
	
	public List<RezervacijeSobeDTO> findAll(){
		Optional<List<RezervacijeSobe>> list = Optional.of(rezervacijeSobeRepository.findAll());
		ArrayList<RezervacijeSobeDTO> arrayDTO = new ArrayList<RezervacijeSobeDTO>();
		if(list.isPresent()) {
			for(RezervacijeSobe item : list.get()) {
				arrayDTO.add(rezervacijeSobeConverter.convertToDTO(item));
			}
			return arrayDTO;
		}
		return Collections.emptyList();
	}
	
	public RezervacijeSobeDTO save(RezervacijeSobeDTO dto) {
		rezervacijeSobeRepository.save(rezervacijeSobeConverter.convertFromDTO(dto));
		return dto;
	}
	
	public RezervacijeSobeDTO deleteById(Long id) {
		
		Optional<RezervacijeSobe> zaBrisanje = rezervacijeSobeRepository.findById(id);
		
		if(zaBrisanje.isPresent()) {
			rezervacijeSobeRepository.deleteById(id);
			return rezervacijeSobeConverter.convertToDTO(zaBrisanje.get());
		}else {
			return null;
		}
		
	}
	
	public RezervacijeSobeDTO change(Long id, RezervacijeSobeDTO dto) {
		
		Optional<RezervacijeSobe> zaIzmenu = rezervacijeSobeRepository.findById(id);
		
		if(zaIzmenu.isPresent() && dto!=null) {
			
			zaIzmenu.get().setDateFrom(dto.getDateFrom());
			zaIzmenu.get().setDateUntil(dto.getDateUntil());
			zaIzmenu.get().setRating(dto.getRating());
			zaIzmenu.get().setTotalPrice(dto.getTotalPrice());
			zaIzmenu.get().setHotelskaSoba_rezervacijeSobe(hotelskaSobaConverter.convertFromDTO(dto.getHotelskaSoba_rezervacijeSobe()));
			
			rezervacijeSobeRepository.save(zaIzmenu.get());
			
			dto.setId(zaIzmenu.get().getId());
			
			return dto;
		}
		
		return null;
		
	}
	
	
}
