package com.ftn.isa.projekat.purchases.purchasesCore.carRating.service;

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
		carRatingRepository.save(carRatingConverter.convertFromDTO(carRatingToSave));
		
		return carRatingToSave;
	}

	@Override
	public CarRatingDTO deleteById(Long id) {
		
		Optional<CarRating> carRatingToDelete = carRatingRepository.findById(id);
		
		if( carRatingToDelete.isPresent() ) {
		
			carRatingRepository.deleteById(id);
			return carRatingConverter.convertToDTO(carRatingToDelete.get());
		
		}
		
		return null;
		
	}

	@Override
	public CarRatingDTO changeCarRating(Long id, CarRatingDTO carRating) {
		
		Optional<CarRating> carRatingForChange = carRatingRepository.findById(id);
		
		if(carRatingForChange.isPresent() && carRating != null) {
			
			
				
				carRatingForChange.get().setCarId(carRating.getCarId());
				carRatingForChange.get().setRating(carRating.getRating());
				carRatingForChange.get().setUserId(carRating.getUserId());
				
				carRatingRepository.save(carRatingForChange.get());
				
				carRating.setId(carRatingForChange.get().getId());
				
				return carRating;
			
			
			
		}
		return null;
		
	}

	
	
}
