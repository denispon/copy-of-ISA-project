package com.ftn.isa.projekat.purchases.purchasesCore.converter;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.ReservationDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.reservation.model.Reservation;
@Component
public class DTOReservationConverter {

	public ReservationDTO convertToDTO (Reservation bean) {
		
		ReservationDTO dto = new ReservationDTO();
		
		dto.setCarReservationId(bean.getCarReservationId());
		dto.setId(bean.getId());
		dto.setUserId(bean.getUserId());
		
		return dto;
		
	}
	
	public Reservation convertFromDTO (ReservationDTO dto) {
		
		Reservation bean = new Reservation();
		
		bean.setCarReservationId(dto.getCarReservationId());
		bean.setId(dto.getId());
		bean.setUserId(dto.getUserId());
		
		return bean;
	}
	
}
