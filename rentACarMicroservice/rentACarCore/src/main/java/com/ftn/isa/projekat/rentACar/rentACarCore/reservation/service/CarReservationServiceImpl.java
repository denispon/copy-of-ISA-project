package com.ftn.isa.projekat.rentACar.rentACarCore.reservation.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarReservationDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.repository.BranchOfficeRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.repository.CarRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOBranchOfficeConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOCarConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOCarReservationConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTORentACarServiceConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.repository.RentACarServiceRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.model.CarReservation;
import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.repository.CarReservationRepository;

@Component
public class CarReservationServiceImpl implements ICarReservationService {

	@Autowired
	CarReservationRepository reservationRepository;
	@Autowired
	CarRepository carRepository;
	@Autowired
	BranchOfficeRepository branchOfficeRepository;
	@Autowired
	RentACarServiceRepository rentACarRepository;
	
	@Autowired
	DTOCarReservationConverter reservationConverter;
	@Autowired
	DTOCarConverter carConverter;
	@Autowired
	DTOBranchOfficeConverter branchOfficeConverter;
	@Autowired
	DTORentACarServiceConverter rentACarConverter;
	

	@Override
	public CarReservationDTO findOneById(Long id) {
		
		Optional <CarReservation> reservation = reservationRepository.findById(id);
		
		
		if (reservation.isPresent()) {
			
			return reservationConverter.convertToDTO(reservation.get());
		
		}
		else {
			
			return new CarReservationDTO();
			
		}	
	}

	@Override
	public List<CarReservationDTO> findAll() {
		
		Optional< List<CarReservation> > list = Optional.of(reservationRepository.findAll());
		ArrayList< CarReservationDTO > reservationsDTO = new ArrayList< CarReservationDTO >();
		
		if ( list.isPresent() ) {
			
			for ( CarReservation reservation : list.get()) {
				
				reservationsDTO.add(reservationConverter.convertToDTO(reservation));
				
			}
			
			return reservationsDTO;
			
		}
		
		return Collections.emptyList();

	}

	@Override
	public CarReservationDTO save(CarReservationDTO reservationToSave) {
		
		reservationRepository.save(reservationConverter.convertFromDTO(reservationToSave));
		
		return reservationToSave;

	}

	@Override
	public CarReservationDTO deleteById(Long id) {
		
		Optional<CarReservation> reservationToDelete = reservationRepository.findById(id);
	
		if( reservationToDelete.isPresent() ) {
			
			//Preventing user to delete reservation if reservation starts in less than 2 days
			if(LocalDate.now().isAfter(reservationToDelete.get().getDateFrom().minusDays(2))) {
				
				return new CarReservationDTO();
				
			}
		
			reservationRepository.deleteById(id);
			return reservationConverter.convertToDTO(reservationToDelete.get());
		
		}
		
		return new CarReservationDTO();
	}
	
	@Override
	public CarReservationDTO deleteByIdNoConditions(Long id) {
		
		Optional<CarReservation> reservationToDelete = reservationRepository.findById(id);	
		
		if( reservationToDelete.isPresent() ) {
			reservationRepository.deleteById(id);
			return reservationConverter.convertToDTO(reservationToDelete.get());
		
		}
		
		return new CarReservationDTO();
	}

	@Override
	public CarReservationDTO changeReservation(Long id, CarReservationDTO reservation) {
		
		Optional<CarReservation> reservationForChange = reservationRepository.findById(id);
		
		if(reservationForChange.isPresent() && reservation != null) {
			
			Optional<BranchOffice> branchFrom = branchOfficeRepository.findById(reservation.getBranchOfficeFrom().getId());
			Optional<BranchOffice> branchTo = branchOfficeRepository.findById(reservation.getBranchOfficeTo().getId());
			Optional<RentACarService> rentService = rentACarRepository.findById(reservation.getService().getId());
			Optional<Car> reservedCar = carRepository.findById(reservation.getReservedCar().getId());
			
			
			
			if(rentService.isPresent() && branchFrom.isPresent() && branchTo.isPresent() && reservedCar.isPresent()) {
				
				reservationForChange.get().setBranchOfficeFrom(branchFrom.get());
				reservationForChange.get().setBranchOfficeTo(branchTo.get());
				reservationForChange.get().setReservationRentService(rentService.get());
				reservationForChange.get().setDateFrom(reservation.getDateFrom());
				reservationForChange.get().setDateTo(reservation.getDateTo());
				reservationForChange.get().setRating(reservation.getRating());
				reservationForChange.get().setReservedCar(reservedCar.get());
				
				
				reservationRepository.save(reservationForChange.get());
				
				reservation.setId(reservationForChange.get().getId());
				
				return reservation;
				
			}
		}
		
		return new CarReservationDTO();
	}

	

	
	

	
	
	
	
}
