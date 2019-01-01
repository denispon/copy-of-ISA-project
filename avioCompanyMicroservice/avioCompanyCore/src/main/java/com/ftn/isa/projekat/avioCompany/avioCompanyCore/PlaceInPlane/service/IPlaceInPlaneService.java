package com.ftn.isa.projekat.avioCompany.avioCompanyCore.PlaceInPlane.service;

import java.util.List;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.PlaceInPlaneDTO;

public interface IPlaceInPlaneService {

	PlaceInPlaneDTO findOneById(Long id);

	List<PlaceInPlaneDTO> findAll();

	PlaceInPlaneDTO save(PlaceInPlaneDTO dto);

	PlaceInPlaneDTO deleteById(Long id);

	PlaceInPlaneDTO changePlace(Long id, PlaceInPlaneDTO placeToUpdate);

}
