package com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;
@Component
public class DTOCarConverter {
	
	@Autowired
	private DTOCarTypeConverter carTypeConverter;
	@Autowired
	private DTORentACarServiceConverter rentServiceConverter;
	
	public CarDTO convertToDTO (Car car) {
		
		CarDTO dto = new CarDTO();
		
		dto.setId(car.getId());
		dto.setRegistrationLicence(car.getRegistrationLicence());
		dto.setRentPrice(car.getRentPrice());
		dto.setCarType( carTypeConverter.convertToDTO(car.getCarType()) );
		dto.setService( rentServiceConverter.convertToDTO( car.getCarRentService() ) );
		
		
		return dto;
	}
	
	
	public Car convertFromDTO ( CarDTO carDTO ) {
		
		Car bean = new Car();
		
		bean.setRegistrationLicence(carDTO.getRegistrationLicence());
		bean.setRentPrice(carDTO.getRentPrice());
		bean.setCarType( carTypeConverter.convertFromDTO(carDTO.getCarType()) );
		bean.setCarRentService( rentServiceConverter.convertFromDTO( carDTO.getService() ) );
		
		return bean;
	}
}



