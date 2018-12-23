package com.ftn.isa.projekat.purchases.purchasesCore.converter;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.RentACarRatingDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.rentACarRating.model.RentACarRating;
@Component
public class DTORentACarRatingConverter {
	
	public RentACarRatingDTO convertToDTO (RentACarRating bean) {
		
		RentACarRatingDTO dto = new RentACarRatingDTO();
		
		dto.setId(bean.getId());
		dto.setRating(bean.getRating());
		dto.setRentACarId(bean.getRentACarId());
		dto.setUserId(bean.getUserId());
		
		return dto;
		
	}
	
	public RentACarRating convertFromDTO(RentACarRatingDTO dto) {
		
		RentACarRating bean = new RentACarRating();
		
		bean.setId(dto.getId());
		bean.setRating(dto.getRating());
		bean.setRentACarId(dto.getRentACarId());
		bean.setUserId(dto.getUserId());
		
		return bean;
	}
	

}
