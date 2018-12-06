package com.ftn.isa.projekat.hotel.hotelApi.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VanredneCeneNocenjaDTO {
	
	private Long id;
	private Boolean isItCheaper;
	private int priceChange;
	private Date dateFrom;
	private Date dateUntil;
	private HotelDTO hotel;

}
