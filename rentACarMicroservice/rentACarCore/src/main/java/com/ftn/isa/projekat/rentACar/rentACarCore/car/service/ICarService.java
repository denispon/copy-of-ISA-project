package com.ftn.isa.projekat.rentACar.rentACarCore.car.service;

import java.time.LocalDate;
import java.util.List;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarDTO;


public interface ICarService {

	public CarDTO findOneById ( Long id );
	
	public List<CarDTO> findAll();
	
	public CarDTO save (CarDTO carToSave);
	
	public CarDTO deleteById ( Long id );
	
	public CarDTO changeCar ( Long id, CarDTO car );

	public List<CarDTO> getReservedCarsFromTo(String dateFrom, String dateTo);

	public List<CarDTO> getFreeCarsFromTo(String dateFrom, String dateTo);
	
}
