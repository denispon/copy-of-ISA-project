package com.ftn.isa.projekat.rentACar.rentACarApi.dto;

import lombok.Data;

@Data
public class CarDTO {

	private Long id;
	private String registrationLicence;
	private int rentPrice;
	private CarTypeDTO carType;
	private RentACarServiceDTO service;
	
}
