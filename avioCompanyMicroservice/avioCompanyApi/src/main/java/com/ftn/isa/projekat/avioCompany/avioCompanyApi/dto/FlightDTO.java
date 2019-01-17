package com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO 
{
	private Long id;
	private LocalDateTime takeOffTime;
	private LocalDateTime landingTime;
	private float flightLength;
	private int numberOfTransfers; //broj presedanja
	private int allTickets;
	private int ticketsSold;	
	private String travelType;
	
	private DestinationDTO destinationTakeOff;
	private DestinationDTO destinationLanding;
	private AvioCompanyDTO avioCompany;
}
