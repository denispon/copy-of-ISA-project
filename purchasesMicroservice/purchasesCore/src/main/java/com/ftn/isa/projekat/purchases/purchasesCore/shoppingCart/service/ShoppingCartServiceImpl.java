package com.ftn.isa.projekat.purchases.purchasesCore.shoppingCart.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.ShoppingCartDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.converter.DTOShoppingCartConverter;
import com.ftn.isa.projekat.purchases.purchasesCore.reservation.model.Reservation;
import com.ftn.isa.projekat.purchases.purchasesCore.shoppingCart.model.ShoppingCart;
import com.ftn.isa.projekat.purchases.purchasesCore.shoppingCart.repository.ShoppingCartRepository;

@Component
public class ShoppingCartServiceImpl implements IShoppingCartService{

	@Autowired
	ShoppingCartRepository cartRepository;
	
	@Autowired
	DTOShoppingCartConverter  cartConverter;
	
	@Override
	public ShoppingCartDTO findOneById(Long id) {
		
		Optional <ShoppingCart> reservation = cartRepository.findById(id);
		
		
		if (reservation.isPresent()) {
			
			return cartConverter.convertToDTO(reservation.get());
		
		}
		else {
			
			return new ShoppingCartDTO();
			
		}	
	}

	@Override
	public List<ShoppingCartDTO> findAll() {
		
		Optional< List<ShoppingCart> > list = Optional.of(cartRepository.findAll());
		ArrayList< ShoppingCartDTO > reservationsDTO = new ArrayList< ShoppingCartDTO >();
		
		if ( list.isPresent() ) {
			
			for ( ShoppingCart reservation : list.get()) {
				
				reservationsDTO.add(cartConverter.convertToDTO(reservation));
				
			}
			
			return reservationsDTO;
			
		}
		
		return Collections.emptyList();

	}

	@Override
	public ShoppingCartDTO save(ShoppingCartDTO reservationToSave) {
		
		cartRepository.save(cartConverter.convertFromDTO(reservationToSave));
		
		return reservationToSave;

	}

	@Override
	public ShoppingCartDTO deleteById(Long id) {
		
		Optional<ShoppingCart> reservationToDelete = cartRepository.findById(id);
		
		
		
		
		if( reservationToDelete.isPresent() ) {
			
		
			cartRepository.deleteById(id);
			return cartConverter.convertToDTO(reservationToDelete.get());
		
		}
		
		return null;
	}

	@Override
	public ShoppingCartDTO changeReservation(Long id, ShoppingCartDTO reservation) {
		
		Optional<ShoppingCart> reservationForChange = cartRepository.findById(id);
		
		if(reservationForChange.isPresent() && reservation != null) {
			
			
				
			reservationForChange.get().setCarReservationId(reservation.getCarReservationId());
			reservationForChange.get().setUserId(reservation.getUserId());
			
			
			
			cartRepository.save(reservationForChange.get());
			
			reservation.setId(reservationForChange.get().getId());
			
			return reservation;
				
			
		}
		
		return null;
	}
	
	
}
