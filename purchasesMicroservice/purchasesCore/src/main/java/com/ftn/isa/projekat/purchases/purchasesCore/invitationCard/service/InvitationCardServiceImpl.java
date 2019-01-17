package com.ftn.isa.projekat.purchases.purchasesCore.invitationCard.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.InvitationCardDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.converter.DTOInvitationCardConverter;
import com.ftn.isa.projekat.purchases.purchasesCore.converter.DTOReservationConverter;
import com.ftn.isa.projekat.purchases.purchasesCore.invitationCard.model.InvitationCard;
import com.ftn.isa.projekat.purchases.purchasesCore.invitationCard.repository.InvitationCardRepository;
import com.ftn.isa.projekat.purchases.purchasesCore.reservation.model.Reservation;
import com.ftn.isa.projekat.purchases.purchasesCore.reservation.repository.ReservationRepository;
import com.ftn.isa.projekat.purchases.purchasesCore.utils.DatasFromOtherMicroservices;
import com.ftn.isa.projekat.user.userApi.dto.UserDTO;

@Component
public class InvitationCardServiceImpl implements IInvitationCardService{

	@Autowired
	InvitationCardRepository invitationRepository;
	@Autowired
	ReservationRepository reservationRepository;
	
	
	@Autowired
	DTOInvitationCardConverter invitationConverter;
	@Autowired
	DTOReservationConverter reservationConverterr;
	
	@Autowired
	DatasFromOtherMicroservices servicesProxy;
	
	@Override
	public InvitationCardDTO findOneById(Long id) {
		
		Optional <InvitationCard> invitation = invitationRepository.findById(id);
		
		
		if (invitation.isPresent()) {
			
			return invitationConverter.convertToDTO(invitation.get());
		
		}
		else {
			
			return new InvitationCardDTO();
			
		}	
	}

	@Override
	public List<InvitationCardDTO> findAll() {
		
		Optional< List<InvitationCard> > list = Optional.of(invitationRepository.findAll());
		ArrayList< InvitationCardDTO > invitationsDTO = new ArrayList< InvitationCardDTO >();
		
		if ( list.isPresent() ) {
			
			for ( InvitationCard invitation : list.get()) {
				
				invitationsDTO.add(invitationConverter.convertToDTO(invitation));
				
			}
			
			return invitationsDTO;
			
		}
		
		return Collections.emptyList();

	}

	@Override
	public InvitationCardDTO save(InvitationCardDTO invitationToSave) {
		
		/* 
		 * First we need to see if both of users exits and them cannot be same person
		 * */
		UserDTO user1 = servicesProxy.getUserById(invitationToSave.getUserWhoCreatedId());
		UserDTO user2 = servicesProxy.getUserById(invitationToSave.getInvitedUserId());
		
		if(user1.getId()!=null && user1.getId()!=user2.getId() && user2.getId()!=null) {
		
			invitationRepository.save(invitationConverter.convertFromDTO(invitationToSave));
			
			return invitationToSave;
			
		}
		
		return new InvitationCardDTO();

	}

	@Override
	public InvitationCardDTO deleteById(Long id) {
		
		Optional<InvitationCard> invitationToDelete = invitationRepository.findById(id);
		
		if( invitationToDelete.isPresent() ) {
			
		
			invitationRepository.deleteById(id);
			return invitationConverter.convertToDTO(invitationToDelete.get());
		
		}
		
		return new InvitationCardDTO();
	}

	@Override
	public InvitationCardDTO changeInvitation(Long id, InvitationCardDTO invitation) {
		
		Optional<InvitationCard> invitationForChange = invitationRepository.findById(id);
		
		if(invitationForChange.isPresent() && invitation !=null) {
			
			Optional<Reservation> invitationReservation = reservationRepository.findById(invitation.getReservation().getId());
			
			if(invitationReservation.isPresent()) {
				
				//User who sent invitation and invited user cannot be the same person.
				if(invitation.getInvitedUserId() != invitation.getUserWhoCreatedId()) {
					
					invitationForChange.get().setInvitedUserId(invitation.getInvitedUserId());
					invitationForChange.get().setReservation(invitationReservation.get());
					invitationForChange.get().setStatus(invitation.isStatus());
					invitationForChange.get().setUserWhoCreatedId(invitation.getUserWhoCreatedId());
					
					invitationRepository.save(invitationForChange.get());
					
					invitation.setId(invitationForChange.get().getId());
					
					return invitation;
				}
				
			}
			
			
			
		}
		
		return new InvitationCardDTO();
	}

}
