package com.ftn.isa.projekat.purchases.purchasesCore.shoppingCart.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.ReservationDTO;
import com.ftn.isa.projekat.purchases.purchasesApi.dto.ShoppingCartDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.bonusPoints.model.BonusPoints;
import com.ftn.isa.projekat.purchases.purchasesCore.bonusPoints.repository.BonusPointsRepository;
import com.ftn.isa.projekat.purchases.purchasesCore.bonusPointsDiscounts.model.BonusPointsDiscounts;
import com.ftn.isa.projekat.purchases.purchasesCore.bonusPointsDiscounts.repository.BonusPointsDiscountRepository;
import com.ftn.isa.projekat.purchases.purchasesCore.converter.DTOReservationConverter;
import com.ftn.isa.projekat.purchases.purchasesCore.converter.DTOShoppingCartConverter;
import com.ftn.isa.projekat.purchases.purchasesCore.reservation.model.Reservation;
import com.ftn.isa.projekat.purchases.purchasesCore.reservation.service.IReservationService;
import com.ftn.isa.projekat.purchases.purchasesCore.shoppingCart.model.ShoppingCart;
import com.ftn.isa.projekat.purchases.purchasesCore.shoppingCart.repository.ShoppingCartRepository;
import com.ftn.isa.projekat.purchases.purchasesCore.utils.DatasFromOtherMicroservices;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarReservationDTO;

@Component
public class ShoppingCartServiceImpl implements IShoppingCartService{

	@Autowired
	IReservationService reservationService;
	
	@Autowired
	ShoppingCartRepository cartRepository;
	@Autowired
	BonusPointsRepository bonusPointsRepository;
	@Autowired
	BonusPointsDiscountRepository discountRepository;
	
	@Autowired
	DTOShoppingCartConverter  cartConverter;
	@Autowired
	DTOReservationConverter reservationConverter;
	
	@Autowired
	DatasFromOtherMicroservices servicesProxy;
	
	
	
	
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
		
		return new ShoppingCartDTO();
	}

	@Override
	public ShoppingCartDTO changeReservation(Long id, ShoppingCartDTO reservation) {
		
		Optional<ShoppingCart> reservationForChange = cartRepository.findById(id);
		
		if(reservationForChange.isPresent() && reservation != null) {
			
			
				
			reservationForChange.get().setCarReservationId(reservation.getCarReservationId());
			reservationForChange.get().setUserId(reservation.getUserId());
			reservationForChange.get().setPrice(reservation.getPrice());
			
			
			cartRepository.save(reservationForChange.get());
			
			reservation.setId(reservationForChange.get().getId());
			
			return reservation;
				
			
		}
		
		return new ShoppingCartDTO();
	}

	@Override
	public ShoppingCartDTO addCarReservation(Long id, CarReservationDTO carReservation) {

		Optional<ShoppingCart> reservation = cartRepository.findById(id);
		
		if(reservation.isPresent() && carReservation != null) {
			/*
			 * 
			 * We need to first create carReservation in reservation database.
			 * 
			 * Note: See, we are using client from RentACar microservice...
			 *  */
			
			CarReservationDTO carReservationToSave = servicesProxy.addReservation(carReservation);
			
			//Calclulating price for carResercation
			
			long numberOfDaysOfReservation = Duration.between(carReservationToSave.getDateFrom(), carReservationToSave.getDateTo()).toDays();
			
			Double price = (double) (numberOfDaysOfReservation * carReservationToSave.getReservedCar().getRentPrice());
			
			//On that price we give 5% off 
			
			price = price * 0.95;
			
			
			
			reservation.get().setCarReservationId(carReservationToSave.getId());
			reservation.get().setPrice(reservation.get().getPrice() + price);
			
			cartRepository.save(reservation.get());
			
			return cartConverter.convertToDTO(reservation.get());
			
		}
		
		return new ShoppingCartDTO();
	}

	@Override
	public ShoppingCartDTO deleteCarReservation(Long id) {

		Optional<ShoppingCart> reservation = cartRepository.findById(id);

		if(reservation.isPresent()) {
			
			/*
			 * Now we need to delete car reservation from rent a car database
			 *  */
			
			CarReservationDTO deletedReservation = servicesProxy.deleteCarReservation(reservation.get().getCarReservationId());
					
			
			if(deletedReservation !=null) {
				
				//car reservation is deleted, so we can continue
				
				//Also we need to subtract price of final reservation with price of deleted car reservation
				//Calclulating price for carResercation
				
				long numberOfDaysOfReservation = Duration.between(deletedReservation.getDateFrom(), deletedReservation.getDateTo()).toDays();
				
				Double price = (double) (numberOfDaysOfReservation * deletedReservation.getReservedCar().getRentPrice());
				
				//On that price we give 5% off 
				
				price = price * 0.95;
				
				
				reservation.get().setCarReservationId(null);
				reservation.get().setPrice(reservation.get().getPrice() - price);
				
				cartRepository.save(reservation.get());
				
				return cartConverter.convertToDTO(reservation.get());
			}
			
			
		}
		
		return new ShoppingCartDTO();
		
	}

	@Override
	public ShoppingCartDTO confirmReservation(Long id) {

		/*
		 * First we will create Final reservation and add it to reservations data, then
		 * we will delete same reservation from shopping cart data.
		 *  */
		Reservation reservation = new Reservation();
		
		Optional<ShoppingCart> tempReservation = cartRepository.findById(id);
		
		if(tempReservation.isPresent()) {
			
			reservation.setCarReservationId(tempReservation.get().getCarReservationId());
			reservation.setUserId(tempReservation.get().getUserId());
			
			//saving temporary reservation into final reservations
			ReservationDTO savedReservation = reservationService.save(reservationConverter.convertToDTO(reservation));
			
			if(savedReservation.getId()!=null) {
				
				//now we need to delete temporary reservation from shopping cart
				cartRepository.deleteById(id);
				
				return cartConverter.convertToDTO(tempReservation.get());
			}
			
		}
		
		return new ShoppingCartDTO();
	}

	@Override
	public ShoppingCartDTO addBonusPointsToReservation(Long id, int bonusPoints) {
		
		/*
		 * First we are looking if there is shopping cart reservation at "id", then from information of user in
		 * reservation we are finding his bonus points. With that bonus points we are looking if user has enough
		 * bonus points for action. If there is enough bonus points, we are looking if there is discount for 
		 * that number of bonus points. If is these discount precentage too, we are decreasing total price with it.
		 * 
		 *  */
		Optional<ShoppingCart> tempReservation = cartRepository.findById(id);
		
		if(tempReservation.isPresent()) {
			
			Optional<BonusPoints> bonusPointsByUser = bonusPointsRepository.findOneByUserId(tempReservation.get().getUserId());
			
			if(bonusPointsByUser.get().getPoints() >= bonusPoints) {
				
				Optional<BonusPointsDiscounts> discount =  discountRepository.findOneByPoints(bonusPoints);
				
				if(discount.isPresent()) {
					
					//everything is fine now we need to decrease final price.
					
					Double newPrice = tempReservation.get().getPrice();
					
					newPrice = newPrice * ((100-discount.get().getDiscount())/100);
					
					tempReservation.get().setPrice(newPrice);
					
					cartRepository.save(tempReservation.get());
					
					return cartConverter.convertToDTO(tempReservation.get());
					
				}
				
			}
			
		}
		
		return new ShoppingCartDTO();
		
		
	}
	
	
}
