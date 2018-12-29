package com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarDiscountsDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.carDiscounts.model.CarDiscounts;

@Component
public class DTOCarDiscountsConverter {

	@Autowired
	private DTOCarConverter carConverter;
	
	
	public CarDiscountsDTO convertToDTO (CarDiscounts bean) {
		
		CarDiscountsDTO dto = new CarDiscountsDTO();
		
		dto.setCarDiscountPrecentage(bean.getDiscountPrecentage());
		dto.setDateFrom(bean.getDateFrom());
		dto.setDateTo(bean.getDateTo());
		dto.setId(bean.getId());
		dto.setCarId(carConverter.convertToDTO(bean.getCarOnDiscount()));
		
		return dto;		
	}
	
	
	public CarDiscounts convertFromDTO(CarDiscountsDTO dto) {
		
		CarDiscounts bean = new CarDiscounts();
		
		bean.setCarOnDiscount(carConverter.convertFromDTO(dto.getCarId()));
		bean.setDateFrom(dto.getDateFrom());
		bean.setDateTo(dto.getDateTo());
		bean.setDiscountPrecentage(dto.getCarDiscountPrecentage());
		
		return bean;
		
	}
	
}
