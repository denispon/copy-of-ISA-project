package com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.RentACarServiceDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTORentACarServiceConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.repository.RentACarServiceRepository;

@Service
public class RentACarServiceServiceImpl implements IRentACarServiceService {

	@Autowired
	RentACarServiceRepository rentACarServiceRepository;
	
	@Autowired
	DTORentACarServiceConverter rentACarServiceConverter;

	@Override
	public RentACarServiceDTO findOneById(Long id) {

		Optional <RentACarService> rentACarService = rentACarServiceRepository.findById(id);
		
		
		if (rentACarService.isPresent()) {
			
			return rentACarServiceConverter.convertToDTO(rentACarService.get());
		
		}
		else {
			
			return new RentACarServiceDTO();
			
		}

		
	}

	@Override
	public List<RentACarServiceDTO> findAll() {

		Optional< List<RentACarService> > list = Optional.of(rentACarServiceRepository.findAll());
		ArrayList< RentACarServiceDTO > rentACarServicesDTO = new ArrayList< RentACarServiceDTO >();
		
		if ( list.isPresent() ) {
			
			for ( RentACarService rentACarService : list.get()) {
				
				rentACarServicesDTO.add(rentACarServiceConverter.convertToDTO(rentACarService));
				
			}
			
			return rentACarServicesDTO;
			
		}
		
		return Collections.emptyList();

		
	}

	@Override
	public RentACarServiceDTO save(RentACarServiceDTO rentACarServiceToSave) {
		
		rentACarServiceRepository.save(rentACarServiceConverter.convertFromDTO(rentACarServiceToSave));
		
		return rentACarServiceToSave;

	}

	@Override
	public RentACarServiceDTO deleteById(Long id) {

		Optional<RentACarService> rentACarServiceToDelete = rentACarServiceRepository.findById(id);
		
		if( rentACarServiceToDelete.isPresent() ) {
		
			rentACarServiceRepository.deleteById(id);
			
			return rentACarServiceConverter.convertToDTO(rentACarServiceToDelete.get());
		
		}
		
		return null;

		
	}

	@Override
	public RentACarServiceDTO changeRentACarService(Long id, RentACarServiceDTO rentACarService) {
		
		Optional<RentACarService> rentServiceForChange = rentACarServiceRepository.findById(id);
		
		if(rentServiceForChange.isPresent() && rentACarService != null) {
			
			rentServiceForChange.get().setAdress(rentACarService.getAdress());
			rentServiceForChange.get().setDescription(rentACarService.getDescription());
			rentServiceForChange.get().setName(rentACarService.getName());
		
			rentACarServiceRepository.save(rentServiceForChange.get());
			
			rentACarService.setId(rentServiceForChange.get().getId());
			
			return rentACarService;
		}
		
		return null;
	}
	
	@Override
	public Integer getSumOfIncomes(Long rentService, LocalDate dateFrom, LocalDate dateTo) {
		
		Optional<Integer> sumOfIncomes = rentACarServiceRepository.findSumOfIncomes(rentService,dateFrom,dateTo);
		
		if( sumOfIncomes.isPresent() ) {
			
			return sumOfIncomes.get();
			
		}
		
		return null;
		
	}
	
	@Override
	public Double getAverageRating(Long rentService, LocalDate dateFrom, LocalDate dateTo) {
		
		Optional<Double> averageRating = rentACarServiceRepository.getAverageRating(rentService,dateFrom,dateTo);
		
		if( averageRating.isPresent() ) {
			
			return averageRating.get();
			
		}
		
		return null;
		
	}
}
