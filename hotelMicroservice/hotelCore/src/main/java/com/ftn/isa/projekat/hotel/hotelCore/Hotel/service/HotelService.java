package com.ftn.isa.projekat.hotel.hotelCore.Hotel.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelDTO;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.model.Hotel;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.repository.HotelRepository;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOHotelConverter;

@Component
public class HotelService implements IHotelService{
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	DTOHotelConverter hotelConverter;
	
	public HotelDTO findOneById(Long id) {
		
		Optional<Hotel> hotel=hotelRepository.findById(id);
		
		if(hotel.isPresent()) {
			return hotelConverter.convertToDTO(hotel.get());
		}else {
			return new HotelDTO();
		}
		
	}
	
	public List<HotelDTO> findAll(){
		Optional<List<Hotel>> list = Optional.of(hotelRepository.findAll());
		ArrayList<HotelDTO> hoteliDTO = new ArrayList<HotelDTO>();
		if(list.isPresent()) {
			for(Hotel hotel : list.get()) {
				hoteliDTO.add(hotelConverter.convertToDTO(hotel));
			}
			return hoteliDTO;
		}
		return Collections.emptyList();
	}
	
	public HotelDTO save(HotelDTO hotelDTO) {
		hotelRepository.save(hotelConverter.convertFromDTO(hotelDTO));
		return hotelDTO;
	}
	
	public HotelDTO deleteById(Long id) {
		
		Optional<Hotel> hotel = hotelRepository.findById(id);
		
		if(hotel.isPresent()) {
			hotelRepository.deleteById(id);
			return hotelConverter.convertToDTO(hotel.get());
		}else {
			return null;
		}
		
	}
	
	public HotelDTO change(Long id, HotelDTO hotelDTO) {
		
		Optional<Hotel> hotel = hotelRepository.findById(id);
		
		if(hotel.isPresent() && hotelDTO!=null) {
			hotel.get().setName(hotelDTO.getName());
			hotel.get().setAdress(hotelDTO.getAdress());
			hotel.get().setPromotionalDescription(hotelDTO.getPromotionalDescription());
			
			hotelRepository.save(hotel.get());
			
			hotelDTO.setId(hotel.get().getId());
			
			return hotelDTO;
		}
		
		return null;
		
	}
	
	

}
