package com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.ReservationDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;
import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.model.Reservation;

@Component
public class DTOReservationConverter {

	@Autowired
	private DTOBranchOfficeConverter branchOfficeConverter;
	@Autowired
	private DTOCarConverter carConverter;
	
	
	public ReservationDTO convertToDTO ( Reservation reservation ) {
		
		ReservationDTO dto = new ReservationDTO();
		
		dto.setDateFrom (reservation.getDateFrom());
		dto.setDateTo(reservation.getDateTo());
		dto.setId(reservation.getId());
		dto.setRating(reservation.getRating());
		dto.setBranchOfficeFrom( branchOfficeConverter.convertToDTO( reservation.getBranchOfficeFrom() ) );
		dto.setBranchOfficeTo( branchOfficeConverter.convertToDTO( reservation.getBranchOfficeTo() ) );
		
		
		//moving reserved cars
		List<CarDTO> reservedCarsDTO = new ArrayList<CarDTO> ();
		for (Car car : reservation.getReservedCars()) {
			reservedCarsDTO.add( carConverter.convertToDTO(car));
		}
		
		dto.setReservedCars(reservedCarsDTO);
		
		
		return dto;
	}
	
	public Reservation convertFromDTO (ReservationDTO reservationDTO) {
		
		Reservation bean = new Reservation();
		
		bean.setBranchOfficeFrom( branchOfficeConverter.convertFromDTO( reservationDTO.getBranchOfficeFrom() ));
		bean.setBranchOfficeTo(branchOfficeConverter.convertFromDTO( reservationDTO.getBranchOfficeTo() ));
//		bean.setDateFrom(reservationDTO.getDateFrom());
	//	bean.setDateTo(reservationDTO.getDateTo());
		bean.setRating(reservationDTO.getRating());
		
		//moving reserved cars
		List<Car> beanCars = new ArrayList<Car>();
		for (CarDTO carDto : reservationDTO.getReservedCars()) {
			beanCars.add( carConverter.convertFromDTO(carDto));
		}
		
		bean.setReservedCars(beanCars);
		
		return bean;
	}
}
