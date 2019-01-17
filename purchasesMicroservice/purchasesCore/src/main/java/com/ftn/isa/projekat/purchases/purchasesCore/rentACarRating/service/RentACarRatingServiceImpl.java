package com.ftn.isa.projekat.purchases.purchasesCore.rentACarRating.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import com.ftn.isa.projekat.purchases.purchasesCore.utils.DatasFromOtherMicroservices;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.RentACarServiceDTO;
import com.ftn.isa.projekat.user.userApi.dto.UserDTO;

@Component
public class RentACarRatingServiceImpl implements IRentACarRatingService {

	@Autowired
	RentACarRatingRepository rentAcarRatingRepository;
	
	@Autowired
	DTORentACarRatingConverter rentAcarRatingConverter;
	
	@Autowired
	DatasFromOtherMicroservices servicesProxy;
	
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
		
		/* 
		 * 
		 * First we need to check if user and rent a car service exits...
		 * 
		 * */
		
		UserDTO user = servicesProxy.getUserById(rentAcarRatingToSave.getUserId());
		RentACarServiceDTO rentService = servicesProxy.getRentACarServiceById(rentAcarRatingToSave.getRentACarId());
		
		
		if(user.getId()!=null && rentService.getId()!=null) {
		
			RentACarRating rating = rentAcarRatingConverter.convertFromDTO(rentAcarRatingToSave);
			rating.setRatingDate(LocalDateTime.now());
			
			rentAcarRatingRepository.save(rating);
			
			return rentAcarRatingToSave;
		
		}
		
		return new RentACarRatingDTO();
	}

	@Override
	public RentACarRatingDTO deleteById(Long id) {
		
		Optional<RentACarRating> rentAcarRatingToDelete = rentAcarRatingRepository.findById(id);
		
		if( rentAcarRatingToDelete.isPresent() ) {
		
			rentAcarRatingRepository.deleteById(id);
			return rentAcarRatingConverter.convertToDTO(rentAcarRatingToDelete.get());
		
		}
		
		return new RentACarRatingDTO();
		
	}

	@Override
	public RentACarRatingDTO changeRentACarRating(Long id, RentACarRatingDTO carRating) {
		
		Optional<RentACarRating> rentAcarRatingForChange = rentAcarRatingRepository.findById(id);
		
		if(rentAcarRatingForChange.isPresent() && carRating != null) {
			
			/* 
			 * 
			 * First we need to check if user and rent a car service exits...
			 * 
			 * */
			
			UserDTO user = servicesProxy.getUserById(carRating.getUserId());
			RentACarServiceDTO rentService = servicesProxy.getRentACarServiceById(carRating.getRentACarId());
			
			
			if(user.getId()!=null && rentService.getId()!=null) {
				
				rentAcarRatingForChange.get().setRentACarId(carRating.getRentACarId());
				rentAcarRatingForChange.get().setRating(carRating.getRating());
				rentAcarRatingForChange.get().setUserId(carRating.getUserId());
				rentAcarRatingForChange.get().setRatingDate(LocalDateTime.now());
					
				rentAcarRatingRepository.save(rentAcarRatingForChange.get());
					
				carRating.setId(rentAcarRatingForChange.get().getId());
					
				return carRating;
			
			}
			
		}
		return new RentACarRatingDTO();
		
	}

	@Override
	public RentACarRatingDTO rateRentACarService(Long userId, Long rentACarId, int rating) {
		//constraint on rating. We need only ratings between 1-5
		if( rating > 0  &&  rating < 6 ) {
			
			Optional<RentACarRating> rentACarToRate = rentAcarRatingRepository.findByUserId(userId);
			
			
			if(rentACarToRate.isPresent()) {
				//If car rating already exist then we will override it.
				
				rentACarToRate.get().setRating(rating);
				rentACarToRate.get().setRatingDate(LocalDateTime.now());
				
				rentAcarRatingRepository.save(rentACarToRate.get());
				
				return rentAcarRatingConverter.convertToDTO(rentACarToRate.get());
				
			}
			else {
				
				//if this is new rating , then we will crate it
				
				RentACarRating carRating = new RentACarRating();
				
				carRating.setRating(rating);
				carRating.setRentACarId(rentACarId);
				carRating.setUserId(userId);
				carRating.setRatingDate(LocalDateTime.now());
				
				rentAcarRatingRepository.save(carRating);
				
				return rentAcarRatingConverter.convertToDTO(carRating);
				
			}
			
		}
		
		return new RentACarRatingDTO();
		
	}

	@Override
	public Double getAverageRating(Long rentServiceId, LocalDate dateFrom, LocalDate dateTo) {
		
		Optional<Double> averageRating = rentAcarRatingRepository.getAverageRating(rentServiceId,dateFrom,dateTo);
		
		if( averageRating.isPresent() ) {
			
			return averageRating.get();
			
		}
		
		return -1.0;
		
	}

	
	
}
