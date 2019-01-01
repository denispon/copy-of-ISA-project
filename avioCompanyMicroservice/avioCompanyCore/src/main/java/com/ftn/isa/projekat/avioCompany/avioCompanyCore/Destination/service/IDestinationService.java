package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.service;

import java.util.List;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.DestinationDTO;

public interface IDestinationService
{

	DestinationDTO findOneById(Long id);

	List<DestinationDTO> findAll();

	DestinationDTO save(DestinationDTO dto);

	DestinationDTO deleteById(Long id);

	DestinationDTO changeDestination(Long id, DestinationDTO dto);

}
