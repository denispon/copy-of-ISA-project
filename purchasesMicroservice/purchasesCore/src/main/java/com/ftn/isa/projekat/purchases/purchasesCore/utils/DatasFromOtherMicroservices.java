package com.ftn.isa.projekat.purchases.purchasesCore.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.rentACar.rentACarApi.client.CarReservationClient;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarReservationDTO;

@Component
public class DatasFromOtherMicroservices {
	
	@Autowired
	CarReservationClient carReservationClient;
	
	
	public CarReservationDTO deleteCarReservation(Long id) {
		
		return carReservationClient.deleteReservation(id);
	}
	
	public CarReservationDTO addReservation(CarReservationDTO carResercation) {
		
		return carReservationClient.addReservation(carResercation);
	}

}
