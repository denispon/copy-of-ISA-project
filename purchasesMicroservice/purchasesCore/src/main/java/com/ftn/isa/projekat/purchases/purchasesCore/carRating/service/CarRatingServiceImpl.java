package com.ftn.isa.projekat.purchases.purchasesCore.carRating.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.CarRatingDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.carRating.model.CarRating;
import com.ftn.isa.projekat.purchases.purchasesCore.carRating.repository.CarRatingRepository;
import com.ftn.isa.projekat.purchases.purchasesCore.converter.DTOCarRatingConverter;



@Component
public class CarRatingServiceImpl implements ICarRatingService {

	@Autowired
	CarRatingRepository carRatingRepository;
	
	@Autowired
	DTOCarRatingConverter carRatingConverter;
	
	@Override
	public CarRatingDTO findOneById(Long id) {
		Optional <CarRating> carRating = carRatingRepository.findById(id);
		
		
		if (carRating.isPresent()) {
			
			return carRatingConverter.convertToDTO(carRating.get());
		
		}
		else {
			
			return new CarRatingDTO();
			
		}
	}
	
	@Override
	public List<CarRatingDTO> findAll() {
		Optional< List<CarRating> > list = Optional.of(carRatingRepository.findAll());
		ArrayList< CarRatingDTO > carRatingsDTO = new ArrayList< CarRatingDTO >();
		
		if ( list.isPresent() ) {
			
			for ( CarRating carRating : list.get()) {
				
				carRatingsDTO.add(carRatingConverter.convertToDTO(carRating));
				
			}
			
			return carRatingsDTO;
			
		}
		
		return Collections.emptyList();
	}

	@Override
	public CarRatingDTO save(CarRatingDTO carRatingToSave) {
		
		CarRating rating = carRatingConverter.convertFromDTO(carRatingToSave);
		rating.setRatingDate(LocalDate.now());
		carRatingRepository.save(rating);
		
		return carRatingToSave;
	}

	@Override
	public CarRatingDTO deleteById(Long id) {
		
		Optional<CarRating> carRatingToDelete = carRatingRepository.findById(id);
		
		if( carRatingToDelete.isPresent() ) {
		
			carRatingRepository.deleteById(id);
			return carRatingConverter.convertToDTO(carRatingToDelete.get());
		
		}
		
		return new CarRatingDTO();
		
	}

	@Override
	public CarRatingDTO changeCarRating(Long id, CarRatingDTO carRating) {
		
		Optional<CarRating> carRatingForChange = carRatingRepository.findById(id);
		
		if(carRatingForChange.isPresent() && carRating != null) {
			
			
				
				carRatingForChange.get().setCarId(carRating.getCarId());
				carRatingForChange.get().setRating(carRating.getRating());
				carRatingForChange.get().setUserId(carRating.getUserId());
				carRatingForChange.get().setRatingDate(LocalDate.now());
				
				carRatingRepository.save(carRatingForChange.get());
				
				carRating.setId(carRatingForChange.get().getId());
				
				return carRating;
			
			
			
		}
		return new CarRatingDTO();
		
	}

	@Override
	public CarRatingDTO rateCarReservation(Long userId, Long carId, int rating) {
		//constraint on rating. We need only ratings between 1-5
		if( rating > 0  &&  rating < 6 ) {
			
			Optional<CarRating> carToRate = carRatingRepository.findByUserId(userId);
			
			
			if(carToRate.isPresent()) {
				//If car rating already exist then we will override it.
				
				carToRate.get().setRating(rating);
				//Update date when rating was changed
				carToRate.get().setRatingDate(LocalDate.now());
				
				carRatingRepository.save(carToRate.get());
				
				return carRatingConverter.convertToDTO(carToRate.get());
				
			}
			else {
				
				//if this is new rating , then we will crate it
				
				CarRating carRating = new CarRating();
				
				carRating.setRating(rating);
				carRating.setCarId(carId);
				carRating.setUserId(userId);
				carRating.setRatingDate(LocalDate.now());
				
				carRatingRepository.save(carRating);
				
				return carRatingConverter.convertToDTO(carRating);
				
			}
			
		}
		
		return new CarRatingDTO();
		
	}
	
	

	
	
}
