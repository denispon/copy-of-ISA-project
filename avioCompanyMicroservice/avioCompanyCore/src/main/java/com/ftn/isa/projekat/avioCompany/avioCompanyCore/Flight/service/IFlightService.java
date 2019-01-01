package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.service;

import java.util.List;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.FlightDTO;

public interface IFlightService {

	FlightDTO findOneById(Long id);

	List<FlightDTO> findAll();

	FlightDTO save(FlightDTO dto);

	FlightDTO deleteById(Long id);

	FlightDTO changeFlight(Long id, FlightDTO dto);

}
