package com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.service;

import java.util.List;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioCompanyDTO;

public interface IAvioCompanyService
{

	AvioCompanyDTO findOneById(Long id);

	List<AvioCompanyDTO> findAll();

	AvioCompanyDTO save(AvioCompanyDTO dto);

	AvioCompanyDTO deleteById(Long id);

	AvioCompanyDTO changeAvioCompany(Long id, AvioCompanyDTO avioDto);


}
