package com.ftn.isa.projekat.avioCompany.avioCompanyCore.PlaceInPlane.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.PlaceInPlaneDTO;

@Component
public interface IPlaceInPlaneService {

	PlaceInPlaneDTO findOneById(Long id);

	List<PlaceInPlaneDTO> findAll();

	PlaceInPlaneDTO save(PlaceInPlaneDTO dto);

	PlaceInPlaneDTO deleteById(Long id);

	PlaceInPlaneDTO changePlace(Long id, PlaceInPlaneDTO placeToUpdate);

}
