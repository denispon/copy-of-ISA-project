package com.ftn.isa.projekat.rentACar.rentACarApi.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReservationDTO {

	private Long id;
	private Date dateFrom;
	private Date dateTo;
	private int rating;
	
}
