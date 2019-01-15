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
	private float price;
	private int rating;
	
	private FlightDTO flight;
}
