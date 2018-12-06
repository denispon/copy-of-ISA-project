package com.ftn.isa.projekat.hotel.hotelApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelskaSobaDTO {
	
	private Long id;
	private int floor;
	private Boolean reserved;
	private HotelDTO hotel;
	private TipSobeDTO tipSobe;

}
