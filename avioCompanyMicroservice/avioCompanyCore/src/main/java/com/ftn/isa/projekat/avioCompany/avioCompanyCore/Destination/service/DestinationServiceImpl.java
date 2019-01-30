package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.DestinationDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model.AvioCompany;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.repository.AvioCompanyRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.model.Destination;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.repository.DestinationRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.repository.FlightRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOAvioCompanyConverter;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTODestinationConverter;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOFlightConverter;

@Service
public class DestinationServiceImpl implements IDestinationService
{
	@Autowired
	DestinationRepository destRepository;
	@Autowired
	DTODestinationConverter destConverter;
	
	@Autowired
	AvioCompanyRepository avioRepository;
	@Autowired
	DTOAvioCompanyConverter avioConverter;
	
	@Autowired
	FlightRepository flRepository;
	@Autowired
	DTOFlightConverter flConverter;

	@Override
	public DestinationDTO findOneById(Long id)
	{
		Optional<Destination> destination = destRepository.findById(id);
		
		if(destination.isPresent())
			return destConverter.convertToDto(destination.get());
		else
			return new DestinationDTO();
		
	}

	@Override
	public List<DestinationDTO> findAll() 
	{
		Optional<List<Destination>> destinations = Optional.of(destRepository.findAll());
		ArrayList<DestinationDTO> dtos = new ArrayList<DestinationDTO>();
		
		if(destinations.isPresent())
		{
			for(Destination dest : destinations.get())
			{
				dtos.add(destConverter.convertToDto(dest));
			}
			return dtos;
		}
		
		return Collections.emptyList();
	}

	@Override
	public DestinationDTO save(DestinationDTO dto) 
	{
		//ne kapiram zasto ovde baca
		destRepository.save(destConverter.convertFromDTO(dto));
		
		//ovde je trebalo samo da se sacuva jer kad bi stavio i ovde uslov da ne sme aviokompanija da bude prazna nebi se moglo sacuvati ni jedno ni drugo
		return dto;
	}

	@Override
	public DestinationDTO deleteById(Long id)
	{
		Optional<Destination> dest = destRepository.findById(id);
		
		if(dest.isPresent())
		{
			destRepository.deleteById(id);
			
			return destConverter.convertToDto(dest.get());
		}
		
		return null;
	}

	@Override
	public DestinationDTO changeDestination(Long id, DestinationDTO dto) 
	{
		Optional<Destination> dest = destRepository.findById(id);
		
		if(dest.isPresent() && dto != null)
		{
			dest.get().setName(dto.getName());
			
			destRepository.save(dest.get());
			
			dto.setId(dest.get().getId());
			
			return dto;
		}
		
		return new DestinationDTO();
	}

}
