package com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.service;

import java.util.List;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioIncomeDTO;

public interface IAvioIncomeService
{

	public AvioIncomeDTO findOneById(Long id);

	public List<AvioIncomeDTO> findAll();

	public AvioIncomeDTO save(AvioIncomeDTO dto);

	public AvioIncomeDTO deleteById(Long id);

	public AvioIncomeDTO changeIncome(Long id, AvioIncomeDTO dto);

}
