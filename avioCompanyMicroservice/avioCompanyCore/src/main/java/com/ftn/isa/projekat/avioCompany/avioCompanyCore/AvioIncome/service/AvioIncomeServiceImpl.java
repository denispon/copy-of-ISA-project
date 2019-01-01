

package com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioIncomeDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model.AvioCompany;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.repository.AvioCompanyRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.model.AvioIncome;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.repository.AvioIncomeRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOAvioCompanyConverter;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOAvioIncomeConverter;

@Service
public class AvioIncomeServiceImpl implements IAvioIncomeService
{
	@Autowired
	AvioIncomeRepository incomeRepository;
	//uvezujemo repozitorijume onih servisa koji nisu lista u modelu ovog servisa
	@Autowired
	AvioCompanyRepository companyRepository;
	
	
	@Autowired
	DTOAvioIncomeConverter incomeConverter;
	//takodje uvezujemo i convertere ovih repozitorijuma (u ovom sl to je jedan)
	@Autowired
	DTOAvioCompanyConverter companyConverter;
	
	
	@Override
	public AvioIncomeDTO findOneById(Long id)
	{
		//Optional - kontejner koji moze i ne mora da sadrzi null vrednost. Moze da sadrzi 0 ili 1 vrednost
		//ako sadrzi vrednost, isPresent() ce vratiti true a get() ce vratiti tu vrednost.
		Optional<AvioIncome> income = incomeRepository.findById(id);
		
		if(income.isPresent()) //vraca tacno ako sadrzi vrednost
			return incomeConverter.convertToDTO(income.get());
		else
			return new AvioIncomeDTO();
	}

	@Override
	public List<AvioIncomeDTO> findAll() 
	{
		Optional< List<AvioIncome> > list = Optional.of(incomeRepository.findAll()); //of vraca optional sa trenutnom ne nula vrednosti.
		ArrayList<AvioIncomeDTO> incDto = new ArrayList<AvioIncomeDTO>();
		
		if(list.isPresent())
		{
			for(AvioIncome income : list.get())
			{
				incDto.add(incomeConverter.convertToDTO(income));
			}
				
			return incDto;
		}
		
		return Collections.emptyList();
	}

	@Override
	public AvioIncomeDTO save(AvioIncomeDTO dto)
	{
		incomeRepository.save(incomeConverter.convertFromDTO(dto));
		
		return dto;
	}

	@Override
	public AvioIncomeDTO deleteById(Long id)
	{
		Optional<AvioIncome> incToDelete = incomeRepository.findById(id);
		
		if(incToDelete.isPresent())
		{
			incomeRepository.deleteById(id);
			return incomeConverter.convertToDTO(incToDelete.get());
		}
		return null;
	}

	@Override
	public AvioIncomeDTO changeIncome(Long id, AvioIncomeDTO income)
	{
		Optional<AvioIncome> incToChange = incomeRepository.findById(id);
		
		if(incToChange.isPresent() && income != null)
		{
			//setting AvioCompany for income
			Optional<AvioCompany> company = companyRepository.findById(income.getCompany().getId());
			
			if(company.isPresent())
			{
				incToChange.get().setCompanyId(company.get());
				incToChange.get().setIncome(income.getIncome());
				incToChange.get().setIncomeDate(income.getDateOfIncome());
				incToChange.get().setTicketsNumber(income.getPurchasedTicketsNum());
			
				incomeRepository.save(incToChange.get());
				income.setId(incToChange.get().getId());
				
				return income;
			}
			
		}
		
		return null;
		
	}

}
