package com.ftn.isa.projekat.purchases.purchasesCore.rentACarRating.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.RentACarRatingDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.converter.DTORentACarRatingConverter;
import com.ftn.isa.projekat.purchases.purchasesCore.rentACarRating.model.RentACarRating;
import com.ftn.isa.projekat.purchases.purchasesCore.rentACarRating.repository.RentACarRatingRepository;

@Component
public class RentACarRatingServiceImpl implements IRentACarRatingService {

	@Autowired
	RentACarRatingRepository rentAcarRatingRepository;
	
	@Autowired
	DTORentACarRatingConverter rentAcarRatingConverter;
	
	@Override
	public RentACarRatingDTO findOneById(Long id) {
		Optional <RentACarRating> rentAcarRating = rentAcarRatingRepository.findById(id);
		
		
		if (rentAcarRating.isPresent()) {
			
			return rentAcarRatingConverter.convertToDTO(rentAcarRating.get());
		
		}
		else {
			
			return new RentACarRatingDTO();
			
		}
	}
	
	@Override
	public List<RentACarRatingDTO> findAll() {
		Optional< List<RentACarRating> > list = Optional.of(rentAcarRatingRepository.findAll());
		ArrayList< RentACarRatingDTO > rentAcarRatingsDTO = new ArrayList< RentACarRatingDTO >();
		
		if ( list.isPresent() ) {
			
			for ( RentACarRating rentAcarRating : list.get()) {
				
				rentAcarRatingsDTO.add(rentAcarRatingConverter.convertToDTO(rentAcarRating));
				
			}
			
			return rentAcarRatingsDTO;
			
		}
		
		return Collections.emptyList();
	}

	@Override
	public RentACarRatingDTO save(RentACarRatingDTO rentAcarRatingToSave) {
		rentAcarRatingRepository.save(rentAcarRatingConverter.convertFromDTO(rentAcarRatingToSave));
		
		return rentAcarRatingToSave;
	}

	@Override
	public RentACarRatingDTO deleteById(Long id) {
		
		Optional<RentACarRating> rentAcarRatingToDelete = rentAcarRatingRepository.findById(id);
		
		if( rentAcarRatingToDelete.isPresent() ) {
		
			rentAcarRatingRepository.deleteById(id);
			return rentAcarRatingConverter.convertToDTO(rentAcarRatingToDelete.get());
		
		}
		
		return null;
		
	}

	@Override
	public RentACarRatingDTO changeRentACarRating(Long id, RentACarRatingDTO carRating) {
		
		Optional<RentACarRating> rentAcarRatingForChange = rentAcarRatingRepository.findById(id);
		
		if(rentAcarRatingForChange.isPresent() && carRating != null) {
			
			
				
			rentAcarRatingForChange.get().setRentACarId(carRating.getRentACarId());
			rentAcarRatingForChange.get().setRating(carRating.getRating());
			rentAcarRatingForChange.get().setUserId(carRating.getUserId());
				
			rentAcarRatingRepository.save(rentAcarRatingForChange.get());
				
			carRating.setId(rentAcarRatingForChange.get().getId());
				
			return carRating;
			
			
			
		}
		return null;
		
	}

	
	
}
