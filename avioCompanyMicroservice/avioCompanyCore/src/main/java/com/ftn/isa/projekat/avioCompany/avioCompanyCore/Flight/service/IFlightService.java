package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.FlightDTO;

@Component
public interface IFlightService {

	FlightDTO findOneById(Long id);

	List<FlightDTO> findAll();

	FlightDTO save(FlightDTO dto);

	FlightDTO deleteById(Long id);

	FlightDTO changeFlight(Long id, FlightDTO dto);
	
	List<FlightDTO> getFlightsByDate(LocalDate takeOffTime, LocalDate landingTime); //radi

	float getAvgRating(Long id);

	List<FlightDTO> getFlightsByPrice(float bottomPrice, float topPrice);

}
