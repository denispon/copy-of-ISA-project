package com.ftn.isa.projekat.purchases.purchasesCore.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.rentACar.rentACarApi.client.CarClient;
import com.ftn.isa.projekat.rentACar.rentACarApi.client.CarReservationClient;
import com.ftn.isa.projekat.rentACar.rentACarApi.client.RentACarServiceClient;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarReservationDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.RentACarServiceDTO;
import com.ftn.isa.projekat.user.userApi.client.UserClient;
import com.ftn.isa.projekat.user.userApi.dto.UserDTO;

@Component
public class DatasFromOtherMicroservices {
	
	@Autowired
	CarReservationClient carReservationClient;
	
	@Autowired
	CarClient carClient;
	
	@Autowired
	RentACarServiceClient rentClient;
	
	@Autowired
	UserClient userClient;
	
	
	public CarReservationDTO deleteCarReservation(Long id) {
		
		return carReservationClient.deleteReservation(id);
	}
	
	public CarReservationDTO addReservation(CarReservationDTO carResercation) {
		
		return carReservationClient.addReservation(carResercation);
	}
	
	
	public CarDTO getCarById(Long id) {
		
		return carClient.getOneCarById(id);
	}
	
	public RentACarServiceDTO getRentACarServiceById(Long id) {
		
		return rentClient.getOneRentACarServiceById(id);
	}
	
	
	/*
	 * 
	 * Methods linked to user
	 * 
	 */
	
	
	public UserDTO getUserById(Long id) {
		
		return userClient.getOneUserById(id);
	}

}
