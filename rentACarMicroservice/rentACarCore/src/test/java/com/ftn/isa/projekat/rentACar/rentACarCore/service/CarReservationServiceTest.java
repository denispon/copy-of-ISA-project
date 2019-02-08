package com.ftn.isa.projekat.rentACar.rentACarCore.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.BranchOfficeDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarReservationDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.RentACarServiceDTO;
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
import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.service.CarReservationServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarReservationServiceTest {

	@Mock
	CarReservationRepository reservationRepository;
	@Mock
	CarRepository carRepository;
	@Mock
	BranchOfficeRepository branchOfficeRepository;
	@Mock
	RentACarServiceRepository rentACarRepository;
	
	@Mock
	DTOCarReservationConverter reservationConverter;
	@Mock
	DTOCarConverter carConverter;
	@Mock
	DTOBranchOfficeConverter branchOfficeConverter;
	@Mock
	DTORentACarServiceConverter rentACarConverter;
	
	@Mock
	CarReservation carReservation;
	
	@InjectMocks
	CarReservationServiceImpl reservationService;
	
	@Test
	public void testFindAll() {
		when(reservationRepository.findAll()).thenReturn(Arrays.asList(new CarReservation()));
		when(reservationConverter.convertToDTO(carReservation)).thenReturn(new CarReservationDTO());
		List<CarReservationDTO> reservations = reservationService.findAll();
		assertThat(reservations).hasSize(1);
		
		
		verify(reservationRepository, times(1)).findAll();
        verifyNoMoreInteractions(reservationRepository);
	}
	
	
	@Test
	public void testfindOneById() {
		CarReservationDTO dto = new CarReservationDTO();
		dto.setId(2l);
		
		when(reservationRepository.findById(2l)).thenReturn(Optional.of(carReservation));
		when(reservationConverter.convertToDTO(carReservation)).thenReturn(dto);
		CarReservationDTO foundObject = reservationService.findOneById(2l);
	
		assertEquals(foundObject,dto);
        verify(reservationRepository, times(1)).findById(2l);
        verifyNoMoreInteractions(reservationRepository);

	}
	
	@Test
	public void testSave() {
		
		CarReservationDTO dto = new CarReservationDTO();
		String dateFrom = "2000-01-10T00:00:00";
		String dateTo = "3000-03-03T00:00:00";
		dto.setDateFrom(LocalDateTime.parse(dateFrom));
		dto.setDateTo(LocalDateTime.parse(dateTo));
		
		RentACarServiceDTO rentDTO = new RentACarServiceDTO();
		rentDTO.setId(2l);
		BranchOfficeDTO branchDTO = new BranchOfficeDTO();
		branchDTO.setId(2l);
		branchDTO.setRentServiceDTO(rentDTO);
		CarDTO carDTO = new CarDTO();
		carDTO.setId(2l);
		carDTO.setRentService(rentDTO);
		
		
		dto.setReservedCar(carDTO);
		dto.setBranchOfficeFrom(branchDTO);
		dto.setBranchOfficeTo(branchDTO);
		dto.setService(rentDTO);
		
		
		//postavljanje i beanova
		RentACarService rent = new RentACarService();
		rent.setId(2l);
		BranchOffice branch = new BranchOffice();
		branch.setId(2l);
		branch.setBranchRentService(rent);
		Car car = new Car();
		car.setCarRentService(rent);
		
		when(branchOfficeRepository.findById(2l)).thenReturn(Optional.of(branch));
		when(rentACarRepository.findById(2l)).thenReturn(Optional.of(rent));
		when(carRepository.findById(2l)).thenReturn(Optional.of(car));	
		when(reservationConverter.convertFromDTO(dto)).thenReturn(carReservation);
		when(reservationRepository.save(carReservation)).thenReturn(carReservation);
		
		CarReservationDTO dto111 = reservationService.save(dto);

        verify(carRepository, times(1)).findById(2l);
        verify(branchOfficeRepository, times(2)).findById(2l);
        verify(rentACarRepository, times(1)).findById(2l);
        verify(reservationRepository, times(1)).save(carReservation);
		
		
	}
	
	
}
