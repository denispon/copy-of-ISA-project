package com.ftn.isa.projekat.hotel.hotelApi.dto;

import org.springframework.boot.jackson.JsonComponent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonComponent
@NoArgsConstructor
@AllArgsConstructor
public class HotelskaSobaDTO {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public Boolean getReserved() {
		return reserved;
	}
	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
	}
	public HotelDTO getHotel_hotelskeSobe() {
		return hotel_hotelskeSobe;
	}
	public void setHotel_hotelskeSobe(HotelDTO hotel_hotelskeSobe) {
		this.hotel_hotelskeSobe = hotel_hotelskeSobe;
	}
	public TipSobeDTO getTipSobe_hotelskeSobe() {
		return tipSobe_hotelskeSobe;
	}
	public void setTipSobe_hotelskeSobe(TipSobeDTO tipSobe_hotelskeSobe) {
		this.tipSobe_hotelskeSobe = tipSobe_hotelskeSobe;
	}
	private Long id;
	private int floor;
	private Boolean reserved;
	private HotelDTO hotel_hotelskeSobe;
	private TipSobeDTO tipSobe_hotelskeSobe;

}
