package com.ftn.isa.projekat.avioCompany.avioCompanyCore.TransferLocation.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.TransferLocationDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.TransferLocation.model.TransferLocation;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.TransferLocation.repository.TransferLocationRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOTransferLocationConverter;

@Service
public class TransferLocationServiceImpl implements ITransferLocationService
{
	@Autowired
	TransferLocationRepository repository;
	
	@Autowired
	DTOTransferLocationConverter converter;
	
	@Override
	public TransferLocationDTO findOneById(Long id) 
	{
		Optional<TransferLocation> transfer = repository.findById(id);
		
		if(transfer.isPresent())
			return converter.convertToDto(transfer.get());
		else
			return new TransferLocationDTO();
		
	}

	@Override
	public List<TransferLocationDTO> findAll() 
	{
		Optional<List<TransferLocation>> list = Optional.of(repository.findAll());
		ArrayList<TransferLocationDTO> dtos = new ArrayList<TransferLocationDTO>();
		
		if(list.isPresent())
		{
			for(TransferLocation loc : list.get())
			{
				dtos.add(converter.convertToDto(loc));
			}
			
			return dtos;
		}
		
		return Collections.emptyList();
	}

	@Override
	public TransferLocationDTO save(TransferLocationDTO dto)
	{
		repository.save(converter.convertFromDto(dto));
		
		return dto;
	}

	@Override
	public TransferLocationDTO deleteById(Long id) 
	{
		Optional<TransferLocation> locToDel = repository.findById(id);
		
		if(locToDel.isPresent())
		{
			repository.deleteById(id);
			return converter.convertToDto(locToDel.get());
		}
		
		return null;
	}

	//URADI UPDATE
	@Override
	public TransferLocationDTO changeLocation(Long id, TransferLocationDTO transferLocationDTO)
	{

		return null;
	}

}
