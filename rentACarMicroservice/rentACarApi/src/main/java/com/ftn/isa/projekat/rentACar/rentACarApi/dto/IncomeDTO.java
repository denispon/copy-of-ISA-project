package com.ftn.isa.projekat.rentACar.rentACarApi.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class IncomeDTO {

	private Long id;
	
	private int rentIncome;
	private int numberOfCars;
	
	private LocalDate date;
	private RentACarServiceDTO rentService;
	
	
}
