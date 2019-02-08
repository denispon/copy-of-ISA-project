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
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarDiscountsDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarTypeDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.RentACarServiceDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.repository.CarRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.carDiscounts.model.CarDiscounts;
import com.ftn.isa.projekat.rentACar.rentACarCore.carDiscounts.repository.CarDiscountsRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.carDiscounts.service.CarDiscountsServiceImpl;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOCarConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOCarDiscountsConverter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarDiscountsServiceTest {
	
	@Mock
	CarDiscountsRepository discountRepository;
	
	@Mock
	CarRepository carRepository;
	
	@Mock
	DTOCarDiscountsConverter discountConverter;
	
	@Mock
	DTOCarConverter carConverter;
	
	@Mock
	CarDiscounts carDiscount;
	
	@InjectMocks
	CarDiscountsServiceImpl discountService;
	
	
	@Test
	public void testFindAll() {
		when(discountRepository.findAll()).thenReturn(Arrays.asList(new CarDiscounts()));
		when(discountConverter.convertToDTO(carDiscount)).thenReturn(new CarDiscountsDTO());
		List<CarDiscountsDTO> carDiscounts = discountService.findAll();
		assertThat(carDiscounts).hasSize(1);
		
		
		verify(discountRepository, times(1)).findAll();
        verifyNoMoreInteractions(discountRepository);
	}
	
	
	@Test
	public void testfindOneById() {
		CarDiscountsDTO dto = new CarDiscountsDTO();
		dto.setId(5l);
		
		when(discountRepository.findById(2l)).thenReturn(Optional.of(carDiscount));
		when(discountConverter.convertToDTO(carDiscount)).thenReturn(dto);
		CarDiscountsDTO foundObject = discountService.findOneById(2l);
	
		assertEquals(foundObject,dto);
        verify(discountRepository, times(1)).findById(2l);
        verifyNoMoreInteractions(discountRepository);

	}
	
	@Test
	public void testFindAllByRentService() {
		when(discountRepository.findAllByCarCarRentServiceId(2l)).thenReturn(Optional.of(Arrays.asList(new CarDiscounts())));
		when(discountConverter.convertToDTO(carDiscount)).thenReturn(new CarDiscountsDTO());
		List<CarDiscountsDTO> carDiscounts = discountService.findAllByRentService(2l);
		assertThat(carDiscounts).hasSize(1);
		
		
		verify(discountRepository, times(1)).findAllByCarCarRentServiceId(2l);
        verifyNoMoreInteractions(discountRepository);
	}

	/*
	@Test
	public void testSave() {
		
		CarDiscountsDTO dto1 = new CarDiscountsDTO();
		
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
		
		String date1 = "1000-11-11T00:00:00";
		String date2 = "2000-11-11T00:00:00";
		dto1.setCarDiscountPrecentage(20);
		dto1.setId(-1l);
		dto1.setCarId(dto);
		dto1.setDateFrom(LocalDateTime.parse(date1));
		dto1.setDateTo(LocalDateTime.parse(date2));
		
		when(discountRepository.findCarDiscountByDate(dto1.getCarId().getId(),dto1.getDateFrom(),dto1.getDateTo())).thenReturn(null);
		when(carRepository.findById(dto1.getCarId().getId())).thenReturn(Optional.of(new Car()));
		when(discountConverter.convertFromDTO(dto1)).thenReturn(carDiscount);
		when(discountRepository.save(carDiscount)).thenReturn(carDiscount);
		
		
		CarDiscountsDTO dto1111 = discountService.save(dto1);
		
		
		verify(discountRepository, times(1)).findCarDiscountByDate(dto1.getCarId().getId(),dto1.getDateFrom(),dto1.getDateTo());
        verify(carRepository, times(1)).findById(1l);
        verify(discountRepository, times(1)).save(carDiscount);
				
	}
	
*/
}
