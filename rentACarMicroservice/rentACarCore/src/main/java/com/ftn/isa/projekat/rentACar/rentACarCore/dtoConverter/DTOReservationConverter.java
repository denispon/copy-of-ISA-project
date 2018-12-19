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
	@Autowired
	private DTORentACarServiceConverter rentACarConverter;
	
	
	public ReservationDTO convertToDTO ( Reservation reservation ) {
		
		ReservationDTO dto = new ReservationDTO();
		
		dto.setDateFrom (reservation.getDateFrom());
		dto.setDateTo(reservation.getDateTo());
		dto.setId(reservation.getId());
		dto.setRating(reservation.getRating());
		dto.setCarRating(reservation.getCarRating() );
		dto.setBranchOfficeFrom( branchOfficeConverter.convertToDTO( reservation.getBranchOfficeFrom() ) );
		dto.setBranchOfficeTo( branchOfficeConverter.convertToDTO( reservation.getBranchOfficeTo() ) );
		dto.setService ( rentACarConverter.convertToDTO ( reservation.getReservationRentService() ) );
		dto.setReservedCar( carConverter.convertToDTO( reservation.getReservedCar() ));
		
		
		
		return dto;
	}
	
	public Reservation convertFromDTO (ReservationDTO reservationDTO) {
		
		Reservation bean = new Reservation();
		
		bean.setBranchOfficeFrom( branchOfficeConverter.convertFromDTO( reservationDTO.getBranchOfficeFrom() ));
		bean.setBranchOfficeTo(branchOfficeConverter.convertFromDTO( reservationDTO.getBranchOfficeTo() ));
		bean.setDateFrom(reservationDTO.getDateFrom());
	    bean.setDateTo(reservationDTO.getDateTo());
		bean.setRating(reservationDTO.getRating());
	    bean.setCarRating(reservationDTO.getCarRating());
		bean.setReservationRentService( rentACarConverter.convertFromDTO ( reservationDTO.getService() ) );
		bean.setReservedCar( carConverter.convertFromDTO( reservationDTO.getReservedCar() ) );
	
		
		return bean;
	}
}
