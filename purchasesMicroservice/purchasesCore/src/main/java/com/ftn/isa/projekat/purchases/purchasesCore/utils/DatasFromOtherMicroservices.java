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

import feign.FeignException;

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
		CarReservationDTO carReservation = null;
		try {
			carReservation = carReservationClient.deleteReservation(id);
		}
		catch(FeignException e) {
			return new CarReservationDTO();
		}
		return carReservation;
	}
	
	public CarReservationDTO addCarReservation(CarReservationDTO carResercation) {
		
		CarReservationDTO carReservation = null;
		try {
			carReservation = carReservationClient.addReservation(carResercation);
		}
		catch(FeignException e) {
			return new CarReservationDTO();
		}
		return carReservation;
	}
	
	public CarReservationDTO getCarReservationById(Long id) {
		
		CarReservationDTO carReservation = null;
		try {
			carReservation = carReservationClient.getOneReservationById(id);
		}
		catch(FeignException e) {
			return new CarReservationDTO();
			
		}		
		return carReservation;
	}
	
	
	public CarDTO getCarById(Long id) {
		
		CarDTO car = null;
		try {
			car = carClient.getOneCarById(id);
		}
		catch(FeignException e) {
			new CarDTO();
		}
		return car;
	}
	
	public RentACarServiceDTO getRentACarServiceById(Long id) {
		
		RentACarServiceDTO rentService = null;
		try {
			rentService = rentClient.getOneRentACarServiceById(id);
		}
		catch(FeignException e) {
			new RentACarServiceDTO();
		}
		return rentService;
	}
	
	
	/*
	 * 
	 * Methods linked to user
	 * 
	 */
	
	
	public UserDTO getUserById(Long id) {
		UserDTO user= null;
		try {
		user = userClient.getOneUserById(id);
		}
		catch(FeignException e) {
			return new UserDTO();
		}
		return user;
	}

}
