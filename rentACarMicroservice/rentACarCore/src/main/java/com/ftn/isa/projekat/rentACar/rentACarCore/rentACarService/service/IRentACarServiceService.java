package com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.service;

import java.util.List;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.RentACarServiceDTO;

public interface IRentACarServiceService {
	
	
	public RentACarServiceDTO findOneById ( Long id );
	
	public List<RentACarServiceDTO> findAll();
	
	public RentACarServiceDTO save (RentACarServiceDTO rentACarServiceToSave);
	
	public RentACarServiceDTO deleteById ( Long id );
	
	public RentACarServiceDTO changeRentACarService ( Long id, RentACarServiceDTO rentACarService );


}
