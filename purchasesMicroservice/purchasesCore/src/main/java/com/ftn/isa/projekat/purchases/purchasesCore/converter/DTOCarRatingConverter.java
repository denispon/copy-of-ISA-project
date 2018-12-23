package com.ftn.isa.projekat.purchases.purchasesCore.converter;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.CarRatingDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.carRating.model.CarRating;

@Component
public class DTOCarRatingConverter {
	
	public CarRatingDTO convertToDTO(CarRating carRating) {
		
		CarRatingDTO dto = new CarRatingDTO();
		
		dto.setCarId(carRating.getCarId());
		dto.setId(carRating.getId());
		dto.setRating(carRating.getRating());
		dto.setUserId(carRating.getUserId());
		
		return dto;
		
	}
	
	public CarRating convertFromDTO (CarRatingDTO dto) {
		
		CarRating bean = new CarRating();
		
		bean.setCarId(dto.getCarId());
		bean.setId(dto.getId());
		bean.setRating(dto.getRating());
		bean.setUserId(dto.getUserId());
		
		return bean;
		
	}

}
