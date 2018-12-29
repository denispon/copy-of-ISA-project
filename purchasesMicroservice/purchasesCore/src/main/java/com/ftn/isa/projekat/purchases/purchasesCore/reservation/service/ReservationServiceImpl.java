package com.ftn.isa.projekat.purchases.purchasesCore.reservation.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.ReservationDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.converter.DTOReservationConverter;
import com.ftn.isa.projekat.purchases.purchasesCore.reservation.model.Reservation;
import com.ftn.isa.projekat.purchases.purchasesCore.reservation.repository.ReservationRepository;


@Component
public class ReservationServiceImpl implements IReservationService {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	DTOReservationConverter reservationConverter;
	
	

	@Override
	public ReservationDTO findOneById(Long id) {
		
		Optional <Reservation> reservation = reservationRepository.findById(id);
		
		
		if (reservation.isPresent()) {
			
			return reservationConverter.convertToDTO(reservation.get());
		
		}
		else {
			
			return new ReservationDTO();
			
		}	
	}

	@Override
	public List<ReservationDTO> findAll() {
		
		Optional< List<Reservation> > list = Optional.of(reservationRepository.findAll());
		ArrayList< ReservationDTO > reservationsDTO = new ArrayList< ReservationDTO >();
		
		if ( list.isPresent() ) {
			
			for ( Reservation reservation : list.get()) {
				
				reservationsDTO.add(reservationConverter.convertToDTO(reservation));
				
			}
			
			return reservationsDTO;
			
		}
		
		return Collections.emptyList();

	}

	@Override
	public ReservationDTO save(ReservationDTO reservationToSave) {
		
		reservationRepository.save(reservationConverter.convertFromDTO(reservationToSave));
		
		return reservationToSave;

	}

	@Override
	public ReservationDTO deleteById(Long id) {
		
		Optional<Reservation> reservationToDelete = reservationRepository.findById(id);
		
		if( reservationToDelete.isPresent() ) {
			
		
			reservationRepository.deleteById(id);
			return reservationConverter.convertToDTO(reservationToDelete.get());
		
		}
		
		return null;
	}

	@Override
	public ReservationDTO changeReservation(Long id, ReservationDTO reservation) {
		
		Optional<Reservation> reservationForChange = reservationRepository.findById(id);
		
		if(reservationForChange.isPresent() && reservation != null) {
			
			
				
			reservationForChange.get().setCarReservationId(reservation.getCarReservationId());
			reservationForChange.get().setUserId(reservation.getUserId());
			reservationForChange.get().setPrice(reservation.getPrice());
			
			
			reservationRepository.save(reservationForChange.get());
			
			reservation.setId(reservationForChange.get().getId());
			
			return reservation;
				
			
		}
		
		return null;
	}


}
