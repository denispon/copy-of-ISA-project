package com.ftn.isa.projekat.hotel.hotelApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CenovnikUslugaDTO {
	
	private Long id;
	private int transferPrice;
	private HotelDTO hotel;
	
}
