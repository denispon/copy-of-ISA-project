package com.ftn.isa.projekat.hotel.hotelCore.PrihodiHotela.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.hotel.hotelApi.dto.PrihodiHotelaDTO;

@Service
public interface IPrihodiHotelaService {

	public PrihodiHotelaDTO findOneById(Long id);
	public List<PrihodiHotelaDTO> findAll();
	public PrihodiHotelaDTO save(PrihodiHotelaDTO prihodiHotelaDTO);
	public PrihodiHotelaDTO deleteById(Long id);
	public PrihodiHotelaDTO change(Long id, PrihodiHotelaDTO prihodiHotelaDTO);
	
}
