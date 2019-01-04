package com.ftn.isa.projekat.rentACar.rentACarApi.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CarReservationDTO {

	private Long id;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private int rating;
	private int carRating;
	
	private BranchOfficeDTO branchOfficeFrom;
	private BranchOfficeDTO branchOfficeTo;
	private CarDTO reservedCar;
	private RentACarServiceDTO service;
	
}
