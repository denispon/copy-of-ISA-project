package com.ftn.isa.projekat.hotel.hotelCore.PrihodiHotela.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.CenovnikUslugaDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.PrihodiHotelaDTO;
import com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.model.CenovnikUsluga;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.repository.HotelRepository;
import com.ftn.isa.projekat.hotel.hotelCore.PrihodiHotela.model.PrihodiHotela;
import com.ftn.isa.projekat.hotel.hotelCore.PrihodiHotela.repository.PrihodiHotelaRepository;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOHotelConverter;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOPrihodiHotelaConverter;

@Component
public class PrihodiHotelaService implements IPrihodiHotelaService{
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	DTOHotelConverter hotelConverter;
	
	@Autowired
	PrihodiHotelaRepository prihodiHotelaRepository;
	
	@Autowired
	DTOPrihodiHotelaConverter prihodiHotelaConverter;
	
	public PrihodiHotelaDTO findOneById(Long id) {
		
		Optional<PrihodiHotela> zaPronalazak=prihodiHotelaRepository.findById(id);
		
		if(zaPronalazak.isPresent()) {
			return prihodiHotelaConverter.convertToDTO(zaPronalazak.get());
		}else {
			return new PrihodiHotelaDTO();
		}		
	}
	
	public List<PrihodiHotelaDTO> findAll(){
		Optional<List<PrihodiHotela>> list = Optional.of(prihodiHotelaRepository.findAll());
		ArrayList<PrihodiHotelaDTO> arrayDTO = new ArrayList<PrihodiHotelaDTO>();
		if(list.isPresent()) {
			for(PrihodiHotela item : list.get()) {
				arrayDTO.add(prihodiHotelaConverter.convertToDTO(item));
			}
			return arrayDTO;
		}
		return Collections.emptyList();
	}
	
	public PrihodiHotelaDTO save(PrihodiHotelaDTO dto) {
		prihodiHotelaRepository.save(prihodiHotelaConverter.convertFromDTO(dto));
		return dto;
	}
	
	public PrihodiHotelaDTO deleteById(Long id) {
		
		Optional<PrihodiHotela> zaBrisanje = prihodiHotelaRepository.findById(id);
		
		if(zaBrisanje.isPresent()) {
			prihodiHotelaRepository.deleteById(id);
			return prihodiHotelaConverter.convertToDTO(zaBrisanje.get());
		}else {
			return null;
		}
		
	}
	
	public PrihodiHotelaDTO change(Long id, PrihodiHotelaDTO dto) {
		
		Optional<PrihodiHotela> zaIzmenu = prihodiHotelaRepository.findById(id);
		
		if(zaIzmenu.isPresent() && dto!=null) {
			
			zaIzmenu.get().setIncome(dto.getIncome());
			zaIzmenu.get().setIncomeDate(dto.getIncomeDate());
			zaIzmenu.get().setBrojIznajmljivanja(dto.getBrojIznajmljivanja());
			zaIzmenu.get().setHotel_prihodiHotela(hotelConverter.convertFromDTO(dto.getHotel_prihodiHotela()));

			prihodiHotelaRepository.save(zaIzmenu.get());
			
			dto.setId(zaIzmenu.get().getId());
			
			return dto;
		}
		
		return null;
		
	}
}
