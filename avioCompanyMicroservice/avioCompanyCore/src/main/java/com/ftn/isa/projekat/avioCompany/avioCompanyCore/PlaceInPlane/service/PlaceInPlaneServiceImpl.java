package com.ftn.isa.projekat.avioCompany.avioCompanyCore.PlaceInPlane.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.PlaceInPlaneDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.PlaceInPlane.model.PlaceInPlane;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.PlaceInPlane.repository.PlaceInPlaneRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOPlaceInPlaneConverter;

@Service
public class PlaceInPlaneServiceImpl implements IPlaceInPlaneService
{
	@Autowired
	PlaceInPlaneRepository repository;
	
	@Autowired
	DTOPlaceInPlaneConverter converter;

	@Override
	public PlaceInPlaneDTO findOneById(Long id)
	{
		Optional<PlaceInPlane> place = repository.findById(id);
		
		if(place.isPresent())
			return converter.convertToDto(place.get());
		else
			return new PlaceInPlaneDTO();
	}

	@Override
	public List<PlaceInPlaneDTO> findAll()
	{
		Optional<List<PlaceInPlane>> list = Optional.of(repository.findAll());
		ArrayList<PlaceInPlaneDTO> dtos = new ArrayList<PlaceInPlaneDTO>();
		
		if(list.isPresent())
		{
			for(PlaceInPlane place : list.get())
			{
				dtos.add(converter.convertToDto(place));
			}
			return dtos;
		}
		
		return Collections.emptyList();
	}

	@Override
	public PlaceInPlaneDTO save(PlaceInPlaneDTO dto)
	{
		repository.save(converter.convertFromDto(dto));
		
		return dto;
	}

	@Override
	public PlaceInPlaneDTO deleteById(Long id) 
	{
		Optional<PlaceInPlane> placeDel = repository.findById(id);
		
		if(placeDel.isPresent())
		{
			repository.deleteById(id);
			return converter.convertToDto(placeDel.get());
		}
		
		return null;
	}

	
	//NIJE DOVRSENA METODA
	@Override
	public PlaceInPlaneDTO changePlace(Long id, PlaceInPlaneDTO placeToUpdate) 
	{
//		Optional<PlaceInPlane> updated = repository.findById(id);
//		
//		if(updated.isPresent() && placeToUpdate != null)
//		{
//			Optional<PlaceInPlane> 
//		}
		
		return null;
	}

}
