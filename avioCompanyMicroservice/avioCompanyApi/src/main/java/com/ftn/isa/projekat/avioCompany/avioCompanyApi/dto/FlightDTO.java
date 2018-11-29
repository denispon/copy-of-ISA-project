package com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO 
{
	Date takeOffTime;
	Date landingTime;
	Date flightTime;
	int flightLength;
	int numberOfTransfers; //broj presedanja
}
