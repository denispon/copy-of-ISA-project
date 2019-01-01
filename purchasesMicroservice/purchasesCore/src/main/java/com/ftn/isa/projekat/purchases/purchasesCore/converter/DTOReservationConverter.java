package com.ftn.isa.projekat.purchases.purchasesCore.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.ReservationDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.reservation.model.Reservation;
@Component
public class DTOReservationConverter {
	
	@Autowired
	DTOInvitationCardConverter invitationConverter;

	public ReservationDTO convertToDTO (Reservation bean) {
		
		ReservationDTO dto = new ReservationDTO();
		
		dto.setCarReservationId(bean.getCarReservationId());
		dto.setId(bean.getId());
		dto.setUserId(bean.getUserId());
		dto.setPrice(bean.getPrice());
		if(bean.getInvitation() != null) {
			dto.setInvitationCard(invitationConverter.convertToDTO(bean.getInvitation()));
		}
		
		return dto;
		
	}
	
	public Reservation convertFromDTO (ReservationDTO dto) {
		
		Reservation bean = new Reservation();
		
		bean.setCarReservationId(dto.getCarReservationId());
		bean.setId(dto.getId());
		bean.setUserId(dto.getUserId());
		bean.setPrice(dto.getPrice());
		if(dto.getInvitationCard() != null) {
			
			bean.setInvitation(invitationConverter.convertFromDTO(dto.getInvitationCard()));
			
		}
		
		return bean;
	}
	
}
