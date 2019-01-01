package com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioCompanyDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model.AvioCompany;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.repository.AvioCompanyRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.repository.AvioIncomeRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOAvioCompanyConverter;

@Service
public class AvioCompanyServiceImpl implements IAvioCompanyService
{
	@Autowired
	AvioCompanyRepository companyRepository;
//	@Autowired
//	AvioIncomeRepository incomerep;
	
	@Autowired
	DTOAvioCompanyConverter companyConverter;
	
	

	@Override
	public AvioCompanyDTO findOneById(Long id)
	{
		Optional<AvioCompany> company = companyRepository.findById(id);
		
		if(company.isPresent())
			return companyConverter.convertToDTO(company.get());
		else
			return new AvioCompanyDTO();
	}

	@Override
	public List<AvioCompanyDTO> findAll() 
	{
		Optional<List<AvioCompany>> list = Optional.of(companyRepository.findAll());
		ArrayList<AvioCompanyDTO> companiesDTO = new ArrayList<AvioCompanyDTO>();
		
		if(list.isPresent())
		{
			for(AvioCompany avio : list.get())
				companiesDTO.add(companyConverter.convertToDTO(avio));
			
			return companiesDTO;
		}
		
		return Collections.emptyList();
		
	}

	@Override
	public AvioCompanyDTO save(AvioCompanyDTO companyToSave)
	{
		companyRepository.save(companyConverter.convertFromDTO(companyToSave));
		
		return companyToSave;
	}

	@Override
	public AvioCompanyDTO deleteById(Long id)
	{
		Optional<AvioCompany> companyToDelete = companyRepository.findById(id);
		
		if(companyToDelete.isPresent())
		{
			companyRepository.deleteById(id);
			return companyConverter.convertToDTO(companyToDelete.get());
		}
		
		return new AvioCompanyDTO();

	}

	@Override
	public AvioCompanyDTO changeAvioCompany(Long id, AvioCompanyDTO avioDto)
	{
		Optional<AvioCompany> companyChange = companyRepository.findById(id);
	
		if(companyChange.isPresent() && avioDto != null)
		{
			companyChange.get().setName(avioDto.getName());
			companyChange.get().setAddress(avioDto.getAddress());
			companyChange.get().setDescription(avioDto.getDescription());
			
			companyRepository.save(companyChange.get());
			
			avioDto.setId(companyChange.get().getId());
			
			return avioDto;
		}
		
		return null;
	}

}
