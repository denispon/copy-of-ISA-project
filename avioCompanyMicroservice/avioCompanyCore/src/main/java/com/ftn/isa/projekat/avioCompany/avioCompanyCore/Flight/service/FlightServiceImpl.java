package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.FlightDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.model.Flight;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.repository.FlightRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOFlightConverter;

@Service
public class FlightServiceImpl implements IFlightService
{
	@Autowired
	FlightRepository repository;
	
	@Autowired
	DTOFlightConverter converter;

	@Override
	public FlightDTO findOneById(Long id)
	{
		Optional<Flight> flight = repository.findById(id);
		
		if(flight.isPresent())
			return converter.convertToDTO(flight.get());
		else
			return new FlightDTO();
	}

	@Override
	public List<FlightDTO> findAll()
	{
		Optional<List<Flight>> list = Optional.of(repository.findAll());
		ArrayList<FlightDTO> flightDto = new ArrayList<FlightDTO>();
		
		if(list.isPresent())
		{
			for(Flight fl : list.get())
			{
				flightDto.add(converter.convertToDTO(fl));
			}
			
			return flightDto;
		}
		
		return Collections.emptyList();
	}

	@Override
	public FlightDTO save(FlightDTO dto) 
	{
		repository.save(converter.convertFromDTO(dto));
		
		return dto;
	}

	@Override
	public FlightDTO deleteById(Long id)
	{
		Optional<Flight> flDel = repository.findById(id);
		
		if(flDel.isPresent())
		{
			repository.deleteById(id);
			return converter.convertToDTO(flDel.get());
		}

		return null;
	}

	@Override
	public FlightDTO changeFlight(Long id, FlightDTO dto)
	{
		Optional<Flight> flUpdate = repository.findById(id);
		
		if(flUpdate.isPresent() && dto != null)
		{
			flUpdate.get().setLandingDate(dto.getLandingTime());
			flUpdate.get().setNumberOfTransfers(dto.getNumberOfTransfers());
			flUpdate.get().setTakeOffDate(dto.getTakeOffTime());
			flUpdate.get().setTravelingDistance(dto.getFlightLength());
			flUpdate.get().setTravelingTime(dto.getFlightTime());
			
			repository.save(flUpdate.get());
			
			dto.setId(flUpdate.get().getId());
			return dto;
		}
		
		return null;
	}

}
