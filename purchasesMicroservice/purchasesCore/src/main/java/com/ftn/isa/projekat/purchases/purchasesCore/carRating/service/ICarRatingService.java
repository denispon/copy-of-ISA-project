package com.ftn.isa.projekat.purchases.purchasesCore.carRating.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.CarRatingDTO;

@Service
public interface ICarRatingService {

	public CarRatingDTO findOneById ( Long id );
	
	public List<CarRatingDTO> findAll();
	
	public CarRatingDTO save (CarRatingDTO carRatingToSave);
	
	public CarRatingDTO deleteById ( Long id );
	
	public CarRatingDTO changeCarRating ( Long id, CarRatingDTO carRating );
	
	public CarRatingDTO rateCarReservation(Long userId, Long carId, int rating);
}
