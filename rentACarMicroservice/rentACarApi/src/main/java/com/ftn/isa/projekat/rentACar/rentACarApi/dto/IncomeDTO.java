package com.ftn.isa.projekat.rentACar.rentACarApi.dto;

import java.util.Date;

import lombok.Data;

@Data
public class IncomeDTO {

	private Long id;
	
	private int rentIncome;
	private int numberOfCars;
	
	private Date date;
	
}
