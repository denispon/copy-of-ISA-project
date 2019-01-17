package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.FlightDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model.AvioCompany;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.repository.AvioCompanyRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.repository.DestinationRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.model.Flight;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.repository.FlightRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOAvioCompanyConverter;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTODestinationConverter;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOFlightConverter;

@Service
public class FlightServiceImpl implements IFlightService
{
	@Autowired
	FlightRepository flRepo;
	@Autowired
	DTOFlightConverter flConv;
	
	@Autowired
	AvioCompanyRepository avioRepo;
	@Autowired
	DTOAvioCompanyConverter avioConv;

	@Override
	public FlightDTO findOneById(Long id)
	{
		Optional<Flight> flight = flRepo.findById(id);
		
		if(flight.isPresent())
			return flConv.convertToDTO(flight.get());
		else
			return new FlightDTO();
	}

	@Override
	public List<FlightDTO> findAll()
	{
		Optional<List<Flight>> list = Optional.of(flRepo.findAll());
		ArrayList<FlightDTO> flightDto = new ArrayList<FlightDTO>();
		
		if(list.isPresent())
		{
			for(Flight fl : list.get())
			{
				flightDto.add(flConv.convertToDTO(fl));
			}
			
			return flightDto;
		}
		
		return Collections.emptyList();
	}

	@Override
	public FlightDTO save(FlightDTO dto) 
	{
		//samo provera za airline, ako to postoji postoji sigurno i ta destinacija, pa ne moram eksplicitno proveravati destinaciju
		Optional<AvioCompany> avio = avioRepo.findById(dto.getAvioCompany().getId());
		
		if(avio.isPresent())
		{
			flRepo.save(flConv.convertFromDTO(dto));
			
			return dto;
		}
				
		return new FlightDTO();
	}

	@Override
	public FlightDTO deleteById(Long id)
	{
		Optional<Flight> flDel = flRepo.findById(id);
		
		if(flDel.isPresent())
		{
			flRepo.deleteById(id);
			return flConv.convertToDTO(flDel.get());
		}

		return null;
	}

	@Override
	public FlightDTO changeFlight(Long id, FlightDTO dto)
	{
		Optional<Flight> flUpdate = flRepo.findById(id);
		
		if(flUpdate.isPresent() && dto != null)
		{
			Optional<AvioCompany> avio = avioRepo.findById(dto.getAvioCompany().getId());
			
			if(avio.isPresent())
			{
				flUpdate.get().setTakeOffTime(dto.getTakeOffTime());
				flUpdate.get().setLandingTime(dto.getLandingTime());
				flUpdate.get().setFlightLength(dto.getFlightLength());
				flUpdate.get().setNumberOfTransfers(dto.getNumberOfTransfers());
				flUpdate.get().setAllTickets(dto.getAllTickets());
				flUpdate.get().setTicketsSold(dto.getTicketsSold());
				flUpdate.get().setTravelType(dto.getTravelType());
				
				flRepo.save(flUpdate.get());
				
				dto.setId(flUpdate.get().getId());
				
				return dto;
			}
			
			
			
			return new FlightDTO();
		}
		
		return null;
	}

	@Override
	public List<FlightDTO> getFlightsByDate(LocalDate takeOffTime, LocalDate landingTime) 
	{
		Optional<List<Flight>> flights = flRepo.findFlightsByDate(takeOffTime, landingTime);
		
		ArrayList<FlightDTO> flDtos = new ArrayList<FlightDTO>();
		
		if(flights.isPresent())
		{
			for(Flight fl : flights.get())
			{
				flDtos.add(flConv.convertToDTO(fl));
			}
			return flDtos;
		}
		
		return Collections.emptyList();
	}


	@Override
	public List<FlightDTO> getFlightsByPrice(float bottomPrice, float topPrice) 
	{
		Optional<List<Flight>> flights = flRepo.findFlightsByPrice(bottomPrice, topPrice);
		
		ArrayList<FlightDTO> flDtos = new ArrayList<FlightDTO>();
		
		if(flights.isPresent())
		{
			for(Flight fl : flights.get())
			{
				flDtos.add(flConv.convertToDTO(fl));
			}
			return flDtos;
		}
		
		return Collections.emptyList();
	}
	
	
	@Override
	public float getAvgRating(Long id)
	{
		float flight = flRepo.findAverageRating(id);
		
		return flight;
	}
	

	
	
}
