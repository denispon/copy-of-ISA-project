package com.ftn.isa.projekat.hotel.hotelApi.dto;

import org.springframework.boot.jackson.JsonComponent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonComponent
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CenovnikUslugaDTO {
	
	private Long id;
	private int transferPrice;
	private HotelDTO hotel_cenovnikUsluga;
	
}
