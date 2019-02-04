package com.ftn.isa.projekat.rentACar.rentACarCore.car.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarDTO;


public interface ICarService {

	public CarDTO findOneById ( Long id );
	
	public List<CarDTO> findAll();
	
	public List<CarDTO> findAllByRentACarService(Long rentId);
	
	public List<CarDTO> getAllNotOnDiscount(LocalDate date);
	
	public List<CarDTO> getAllOnDiscount();
	
	public List<CarDTO> getAllCurrentlyDiscount(LocalDate date);
	
	public CarDTO save (CarDTO carToSave);
	
	public CarDTO deleteById ( Long id );
	
	public CarDTO changeCar ( Long id, CarDTO car );

	public List<CarDTO> getReservedCarsFromTo(LocalDateTime localDateTime, LocalDateTime localDateTime2);

	public List<CarDTO> getFreeCarsFromTo(LocalDateTime localDateTime, LocalDateTime localDateTime2);


	

	

	

	
	
}
