package com.ftn.isa.projekat.hotel.hotelCore.Hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.hotel.hotelApi.dto.CenovnikUslugaDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelskaSobaDTO;

@Service
public interface IHotelService {
	
	public HotelDTO findOneById(Long id);
	public List<HotelDTO> findAll();
	public HotelDTO save(HotelDTO hotelDTO);
	public HotelDTO deleteById(Long id);
	public HotelDTO change(Long id, HotelDTO hotelDTO);
	//public List<HotelskaSobaDTO> findSobeHotela(Long id);
	
}
