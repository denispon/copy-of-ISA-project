package com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;

public class DTOCarConverter {
	
	public CarDTO convertToDTO (Car car) {
		
		CarDTO dto = new CarDTO();
		
		dto.setId(car.getId());
		dto.setRegistrationLicence(car.getRegistrationLicence());
		dto.setRentPrice(car.getRentPrice());
		
		return dto;
	}
	
	
	public Car convertFromDTO ( CarDTO carDTO ) {
		
		Car bean = new Car();
		
		bean.setRegistrationLicence(carDTO.getRegistrationLicence());
		bean.setRentPrice(carDTO.getRentPrice());
		//ovde carType i carRentService treba staviti
		
		return bean;
	}
}



