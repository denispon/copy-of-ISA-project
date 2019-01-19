package com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DestinationDTO
{
	private Long id;
	private String name;
	
	//private AvioCompanyDTO avioCompany;
	//private FlightDTO flightTakeOff;
	private FlightDTO flightLanding;
	
	//da li se pravi zaseban DTO za Many TO many??!?

}
