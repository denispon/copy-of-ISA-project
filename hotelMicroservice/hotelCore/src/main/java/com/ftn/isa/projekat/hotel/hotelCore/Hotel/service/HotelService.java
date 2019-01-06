package com.ftn.isa.projekat.hotel.hotelCore.Hotel.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.CenovnikUslugaDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelskaSobaDTO;
import com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.model.CenovnikUsluga;
import com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.repository.CenovnikUslugaRepository;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.model.Hotel;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.repository.HotelRepository;
import com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.model.HotelskaSoba;
import com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.repository.HotelskaSobaRepository;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOCenovnikConverter;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOHotelConverter;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOHotelskaSobaConverter;

@Component
public class HotelService implements IHotelService{
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	DTOHotelConverter hotelConverter;
	
	@Autowired
	HotelskaSobaRepository hotelskaSobaRepository;
	
	@Autowired
	DTOHotelskaSobaConverter hotelskaSobaConverter;
	
	@Autowired
	CenovnikUslugaRepository cenovnikUslugaRepository;
	
	@Autowired
	DTOCenovnikConverter cenovnikConverter;
	
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
			return new HotelDTO();
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
		
		return new HotelDTO();
		
	}
	
	/*public List<CenovnikUslugaDTO> findCenovnike(Long id){
		Optional<List<CenovnikUsluga>> list = Optional.of(cenovnikUslugaRepository.findAll());
		ArrayList<CenovnikUslugaDTO> uslugeDTO = new ArrayList<CenovnikUslugaDTO>();
		if(list.isPresent()) {
			for(CenovnikUsluga cenovnik : list.get()) {
				if(cenovnik.getHotel_cenovnikUsluga().getId()==id) {
					uslugeDTO.add(cenovnikConverter.convertToDTO(cenovnik));
				}
			}
			return uslugeDTO;
		}
		return Collections.emptyList();
		
	}*/
	
	/*public List<HotelskaSobaDTO> findSobeHotela(Long id){
		Optional<List<HotelskaSoba>> list = Optional.of(hotelskaSobaRepository.findAll());
		ArrayList<HotelskaSobaDTO> sobeDTO = new ArrayList<HotelskaSobaDTO>();
		if(list.isPresent()) {
			for(HotelskaSoba soba : list.get()) {
				sobeDTO.add(hotelskaSobaConverter.convertToDTO(soba));
			}
			return sobeDTO;
		}
		return Collections.emptyList();
		
	}*/		

}
