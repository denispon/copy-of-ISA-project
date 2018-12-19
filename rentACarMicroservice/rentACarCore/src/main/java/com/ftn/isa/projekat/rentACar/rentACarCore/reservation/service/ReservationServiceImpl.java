package com.ftn.isa.projekat.rentACar.rentACarCore.reservation.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.ReservationDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.repository.BranchOfficeRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.repository.CarRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOBranchOfficeConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOCarConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTORentACarServiceConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOReservationConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.repository.RentACarServiceRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.model.Reservation;
import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	CarRepository carRepository;
	@Autowired
	BranchOfficeRepository branchOfficeRepository;
	@Autowired
	RentACarServiceRepository rentACarRepository;
	
	@Autowired
	DTOReservationConverter reservationConverter;
	@Autowired
	DTOCarConverter carConverter;
	@Autowired
	DTOBranchOfficeConverter branchOfficeConverter;
	@Autowired
	DTORentACarServiceConverter rentACarConverter;
	

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
			
			//Preventing user to delete reservation if reservation starts in less than 2 days
			if(LocalDate.now().isAfter(reservationToDelete.get().getDateFrom().minusDays(2))) {
				
				return null;
				
			}
		
			reservationRepository.deleteById(id);
			return reservationConverter.convertToDTO(reservationToDelete.get());
		
		}
		
		return null;
	}

	@Override
	public ReservationDTO changeReservation(Long id, ReservationDTO reservation) {
		
		Optional<Reservation> reservationForChange = reservationRepository.findById(id);
		
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
		
		return null;
	}

	@Override
	public ReservationDTO rateReservation(Long id, int rating) {
		//constraint on rating. We need only ratings between 1-5
		if( rating > 0  &&  rating < 6 ) {
			
			Optional<Reservation> reservationToRate = reservationRepository.findById(id);
			
			if(reservationToRate.isPresent()) {
				
				reservationToRate.get().setRating(rating);
				
				reservationRepository.save(reservationToRate.get());
				
				return reservationConverter.convertToDTO(reservationToRate.get());
				
			}
			
		}
		
		return new ReservationDTO();
		
	}

	@Override
	public ReservationDTO rateCarReservation(Long id, int rating) {
		//constraint on rating. We need only ratings between 1-5
				if( rating > 0  &&  rating < 6 ) {
					
					Optional<Reservation> reservationToRate = reservationRepository.findById(id);
					
					if(reservationToRate.isPresent()) {
						
						reservationToRate.get().setCarRating(rating);
						
						reservationRepository.save(reservationToRate.get());
						
						return reservationConverter.convertToDTO(reservationToRate.get());
						
					}
					
				}
				
				return new ReservationDTO();
				
	}

	
	
	
	
}
