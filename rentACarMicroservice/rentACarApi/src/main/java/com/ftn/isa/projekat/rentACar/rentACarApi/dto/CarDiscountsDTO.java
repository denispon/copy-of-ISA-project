package com.ftn.isa.projekat.rentACar.rentACarApi.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDiscountsDTO {

	private Long id;
	
	private CarDTO carId;
	
	private LocalDate dateFrom;
	
	private LocalDate dateTo;
	
	private int carDiscountPrecentage;
	
}
