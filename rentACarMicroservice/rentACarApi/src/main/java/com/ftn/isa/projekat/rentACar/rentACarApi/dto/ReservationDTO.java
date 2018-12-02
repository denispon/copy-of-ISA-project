package com.ftn.isa.projekat.rentACar.rentACarApi.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ReservationDTO {

	private Long id;
	private Date dateFrom;
	private Date dateTo;
	private int rating;
	
	private BranchOfficeDTO branchOfficeFrom;
	private BranchOfficeDTO branchOfficeTo;
	private List<CarDTO> reservedCars;
	
}
