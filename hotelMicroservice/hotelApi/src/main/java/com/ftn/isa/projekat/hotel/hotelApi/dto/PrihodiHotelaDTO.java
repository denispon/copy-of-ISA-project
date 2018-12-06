package com.ftn.isa.projekat.hotel.hotelApi.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrihodiHotelaDTO {

	private Long id;
	private int income;
	private Date incomeDate;
	private int brojIznajmljivanja;
	private HotelDTO hotel;
	
}
