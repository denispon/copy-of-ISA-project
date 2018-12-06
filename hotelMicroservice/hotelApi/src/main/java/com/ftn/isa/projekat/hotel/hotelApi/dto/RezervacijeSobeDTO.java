package com.ftn.isa.projekat.hotel.hotelApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RezervacijeSobeDTO {

	private Long id;
	private int totalPrice;
	private Date dateFrom;
	private Date dateUntil;
	private int rating;
	private HotelskaSobaDTO hotelskaSoba;
	
}
