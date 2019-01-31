package com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO
{
	private Long id;
	private Boolean fastReservation;
	private String ticketClass;
	private int discount;
	private int rating;
	private float price;
	private Boolean isBought;
	private Boolean isCanceled;
	
	private FlightDTO flight;
}
