package com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioIncomeDTO;

@Component
public interface IAvioIncomeService
{

	public AvioIncomeDTO findOneById(Long id);

	public List<AvioIncomeDTO> findAll();

	public AvioIncomeDTO save(AvioIncomeDTO dto);

	public AvioIncomeDTO deleteById(Long id);

	public AvioIncomeDTO changeIncome(Long id, AvioIncomeDTO dto);

}
