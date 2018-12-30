package com.ftn.isa.projekat.hotel.hotelApi.dto;

import org.springframework.boot.jackson.JsonComponent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonComponent
@NoArgsConstructor
@AllArgsConstructor
public class TipSobeDTO {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getNocenjePrice() {
		return nocenjePrice;
	}
	public void setNocenjePrice(int nocenjePrice) {
		this.nocenjePrice = nocenjePrice;
	}
	public int getPolupansionPrice() {
		return polupansionPrice;
	}
	public void setPolupansionPrice(int polupansionPrice) {
		this.polupansionPrice = polupansionPrice;
	}
	public int getPansionPrice() {
		return pansionPrice;
	}
	public void setPansionPrice(int pansionPrice) {
		this.pansionPrice = pansionPrice;
	}

	public VanredneCeneNocenjaDTO getVanredneCeneNocenja_tipSobe() {
		return vanredneCeneNocenja_tipSobe;
	}
	public void setVanredneCeneNocenja_tipSobe(VanredneCeneNocenjaDTO vanredneCeneNocenja_tipSobe) {
		this.vanredneCeneNocenja_tipSobe = vanredneCeneNocenja_tipSobe;
	}

	private Long id;
	private String roomType;
	private int nocenjePrice;
	private int polupansionPrice;
	private int pansionPrice;
	private VanredneCeneNocenjaDTO vanredneCeneNocenja_tipSobe;
	
}
