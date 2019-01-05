package com.ftn.isa.projekat.hotel.hotelApi.dto;

import org.springframework.boot.jackson.JsonComponent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonComponent
@NoArgsConstructor
@AllArgsConstructor
public class CenovnikUslugaDTO {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getTransferPrice() {
		return transferPrice;
	}
	public void setTransferPrice(int transferPrice) {
		this.transferPrice = transferPrice;
	}
	public HotelDTO getHotel_cenovnikUsluga() {
		return hotel_cenovnikUsluga;
	}
	public void setHotel_cenovnikUsluga(HotelDTO hotel_cenovnikUsluga) {
		this.hotel_cenovnikUsluga = hotel_cenovnikUsluga;
	}
	private Long id;
	private int transferPrice;
	private HotelDTO hotel_cenovnikUsluga;
	
}
