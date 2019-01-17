package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Luggage.service;

import java.util.List;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioCompanyDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.LuggageDTO;

public interface ILuggageService {

	LuggageDTO findOneById(Long id);

	List<LuggageDTO> findAll();

	LuggageDTO save(LuggageDTO dto);

	LuggageDTO deleteById(Long id);

	LuggageDTO changeLuggage(Long id, LuggageDTO luggageDto);

}
