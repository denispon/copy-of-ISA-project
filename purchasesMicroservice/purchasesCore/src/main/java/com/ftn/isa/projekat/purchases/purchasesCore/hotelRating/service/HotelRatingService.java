package com.ftn.isa.projekat.purchases.purchasesCore.hotelRating.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.HotelRatingDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.converter.DTOHotelRatingConverter;
import com.ftn.isa.projekat.purchases.purchasesCore.hotelRating.model.HotelRating;
import com.ftn.isa.projekat.purchases.purchasesCore.hotelRating.repository.HotelRatingRepository;

@Component
public class HotelRatingService implements IHotelRatingService{
	
	@Autowired
	DTOHotelRatingConverter hotelRatingConverter;
	
	@Autowired
	HotelRatingRepository hotelRatingRepository;
	
	public HotelRatingDTO findOneById(Long id) {
		
		Optional<HotelRating> zaPronalazak=hotelRatingRepository.findById(id);
		
		if(zaPronalazak.isPresent()) {
			return hotelRatingConverter.convertToDTO(zaPronalazak.get());
		}else {
			return new HotelRatingDTO();
		}		
	}
	
	public List<HotelRatingDTO> findAll(){
		Optional<List<HotelRating>> list = Optional.of(hotelRatingRepository.findAll());
		ArrayList<HotelRatingDTO> arrayDTO = new ArrayList<HotelRatingDTO>();
		if(list.isPresent()) {
			for(HotelRating item : list.get()) {
				arrayDTO.add(hotelRatingConverter.convertToDTO(item));
			}
			return arrayDTO;
		}
		return Collections.emptyList();
	}
	
	public HotelRatingDTO save(HotelRatingDTO dto) {
		hotelRatingRepository.save(hotelRatingConverter.convertFromDTO(dto));
		//Optional<Hotel> hotel = hotelRepository.findById(dto.getHotel_cenovnikUsluga().getId());//pronadji hotel ciji je cenovnik
		//hotel.get().getCenovnikUsluga().add(cenovnikConverter.convertFromDTO(dto));//dodaj cenovnik u listu cenovnika hotela kome pripada
		return dto;
	}
	
	public HotelRatingDTO deleteById(Long id) {
		
		Optional<HotelRating> zaBrisanje = hotelRatingRepository.findById(id);
		
		if(zaBrisanje.isPresent()) {
			hotelRatingRepository.deleteById(id);
			return hotelRatingConverter.convertToDTO(zaBrisanje.get());
		}else {
			return new HotelRatingDTO();
		}
		
	}
	
	public HotelRatingDTO change(Long id, HotelRatingDTO dto) {
		
		Optional<HotelRating> zaIzmenu = hotelRatingRepository.findById(id);
		
		if(zaIzmenu.isPresent() && dto!=null) {
			
			zaIzmenu.get().setUserId(dto.getUserId());
			zaIzmenu.get().setHotelId(dto.getHotelId());
			zaIzmenu.get().setRating(dto.getRating());
			hotelRatingRepository.save(zaIzmenu.get());
			
			dto.setId(zaIzmenu.get().getId());
			
			return dto;
		}
		
		return new HotelRatingDTO();
		
	}
	
	public Double getHotelAverageRating(Long id) {
		
		Optional<Double> rating = hotelRatingRepository.getHotelAverageRating(id);
		
		if(rating != null) {
			return rating.get();
		}else {
			return null;
		}
	}
	

}
