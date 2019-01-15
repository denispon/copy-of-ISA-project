package com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO 
{
	private Long id;
	private Date takeOffTime;
	private Date landingTime;
	private int flightTime; //u satima
	private float flightLength;
	private int numberOfTransfers; //broj presedanja
	
	private AvioCompanyDTO company;
}
