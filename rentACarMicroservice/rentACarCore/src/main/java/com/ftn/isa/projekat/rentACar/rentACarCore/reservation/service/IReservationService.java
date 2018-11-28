package com.ftn.isa.projekat.rentACar.rentACarCore.reservation.service;

import java.util.List;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.ReservationDTO;

public interface IReservationService {
	
	

	public ReservationDTO findOneById ( Long id );
	
	public List<ReservationDTO> findAll();
	
	public ReservationDTO save (ReservationDTO reservationToSave);
	
	public ReservationDTO deleteById ( Long id );
	
	public ReservationDTO changeReservation ( Long id, ReservationDTO reservation );

	
}
