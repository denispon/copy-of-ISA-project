package com.ftn.isa.projekat.rentACar.rentACarCore.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

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
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarTypeDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.RentACarServiceDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.repository.BranchOfficeRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.repository.CarRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.service.CarServiceImpl;
import com.ftn.isa.projekat.rentACar.rentACarCore.carDiscounts.repository.CarDiscountsRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.carType.model.CarType;
import com.ftn.isa.projekat.rentACar.rentACarCore.carType.repository.CarTypeRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOBranchOfficeConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOCarConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOCarTypeConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTORentACarServiceConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.repository.RentACarServiceRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.repository.CarReservationRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {
	
	@Mock
	private CarRepository carRepositoryMock;
	@Mock
	RentACarServiceRepository rentACarServiceRepository;
	@Mock
	CarTypeRepository carTypeRepository;
	@Mock
	BranchOfficeRepository branchOfficeRepository;
	@Mock
	CarReservationRepository carReservationRepository;
	@Mock
	CarDiscountsRepository discountRepository;
	
	@Mock
	DTOCarConverter carConverterMock;
	@Mock
	DTORentACarServiceConverter rentACarServiceConverter;
	@Mock
	DTOCarTypeConverter carTypeConverter;
	@Mock
	DTOBranchOfficeConverter branchOfficeConverter;
	
	@Mock
	private Car car;
	
	@InjectMocks
	private CarServiceImpl carService;
	
	
	@Test
	public void testFindAll() {
		when(carRepositoryMock.findAll()).thenReturn(Arrays.asList(new Car()));
		when(carConverterMock.convertToDTO(car)).thenReturn(new CarDTO());
		List<CarDTO> cars = carService.findAll();
		assertThat(cars).hasSize(1);
		
		
		verify(carRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(carRepositoryMock);
	}
	
	
	@Test
	public void testfindOneById() {
		CarDTO dto = new CarDTO();
		dto.setId(5l);
		
		when(carRepositoryMock.findById(2l)).thenReturn(Optional.of(car));
		when(carConverterMock.convertToDTO(car)).thenReturn(dto);
		CarDTO foundObject = carService.findOneById(2l);
	
		assertEquals(foundObject,dto);
        verify(carRepositoryMock, times(1)).findById(2l);
        verifyNoMoreInteractions(carRepositoryMock);

	}
	
	@Test
	public void testSave() {
		CarDTO dto = new CarDTO();
		RentACarServiceDTO rentDto = new RentACarServiceDTO();
		BranchOfficeDTO branchDto = new BranchOfficeDTO();
		CarTypeDTO typeDto = new CarTypeDTO();
		
		rentDto.setId(1l);
		branchDto.setId(1l);
		branchDto.setRentServiceDTO(rentDto);
		typeDto.setId(1l);
		
		
		dto.setRentService(rentDto);
		dto.setCarType(typeDto);
		dto.setBranchOffice(branchDto);
		
		dto.setId(-1l);
		
		BranchOffice branchBean = new BranchOffice();
		RentACarService service = new RentACarService();
		service.setId(-1l);
		branchBean.setBranchRentService(service);
		
		when(rentACarServiceRepository.findById(1l)).thenReturn(Optional.of(new RentACarService()));
		when(branchOfficeRepository.findById(1l)).thenReturn(Optional.of(branchBean));
		when(carTypeRepository.findById(1l)).thenReturn(Optional.of(new CarType()));
		when(carConverterMock.convertFromDTO(dto)).thenReturn(car);
		when(carRepositoryMock.save(car)).thenReturn(car);
		
		CarDTO carDto = carService.save(dto);
		
        verify(rentACarServiceRepository, times(1)).findById(1l);
        verify(branchOfficeRepository, times(1)).findById(1l);
        verify(carTypeRepository, times(1)).findById(1l);
	}
	
	

}
