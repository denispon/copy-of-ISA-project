package com.ftn.isa.projekat.hotel.hotelCore.RezervacijeSobe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.hotel.hotelApi.dto.RezervacijeSobeDTO;

@Service
public interface IRezervacijeSobeService {

	public RezervacijeSobeDTO findOneById(Long id);
	public List<RezervacijeSobeDTO> findAll();
	public RezervacijeSobeDTO save(RezervacijeSobeDTO rezervacijeSobeDTO);
	public RezervacijeSobeDTO deleteById(Long id);
	public RezervacijeSobeDTO change(Long id, RezervacijeSobeDTO rezervacijeSobeDTO);
	
}
