package com.ftn.isa.projekat.hotel.hotelApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipSobeDTO {
	
	private Long id;
	private String roomType;
	private int nocenjePrice;
	private int polupansionPrice;
	private int pansionPrice;
	private VanredneCeneNocenjaDTO vanredneCene;
	
}
