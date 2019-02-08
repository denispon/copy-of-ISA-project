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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.IncomeDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.RentACarServiceDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOIncomeConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTORentACarServiceConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.income.model.Income;
import com.ftn.isa.projekat.rentACar.rentACarCore.income.repository.IncomeRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.income.service.IncomeServiceImpl;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.repository.RentACarServiceRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IncomeServiceTest {
	
	@Mock
	IncomeRepository incomeRepository;
	@Mock
	RentACarServiceRepository rentACarServiceRepository;
	
	@Mock
	DTOIncomeConverter incomeConverter;
	@Mock
	DTORentACarServiceConverter rentACarServiceConverter;
	
	@Mock
	Income income;
	
	@InjectMocks
	IncomeServiceImpl incomeService;
	
	@Test
	public void testFindAll() {
		when(incomeRepository.findAll()).thenReturn(Arrays.asList(new Income()));
		when(incomeConverter.convertToDTO(income)).thenReturn(new IncomeDTO());
		List<IncomeDTO> incomes = incomeService.findAll();
		assertThat(incomes).hasSize(1);
		
		
		verify(incomeRepository, times(1)).findAll();
        verifyNoMoreInteractions(incomeRepository);
	}
	
	@Test
	public void testfindOneById() {
		IncomeDTO dto = new IncomeDTO();
		dto.setId(5l);
		
		when(incomeRepository.findById(2l)).thenReturn(Optional.of(income));
		when(incomeConverter.convertToDTO(income)).thenReturn(dto);
		IncomeDTO foundObject = incomeService.findOneById(2l);
	
		assertEquals(foundObject,dto);
        verify(incomeRepository, times(1)).findById(2l);
        verifyNoMoreInteractions(incomeRepository);

	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSave() {
		
		IncomeDTO dto = new IncomeDTO();
		
		dto.setId(-1l);
		
		RentACarServiceDTO rentDTO = new RentACarServiceDTO();
		
		rentDTO.setId(2l);
		
		dto.setRentService(rentDTO);
		
		when(rentACarServiceRepository.findById(2l)).thenReturn(Optional.of(new RentACarService()));
		when(incomeConverter.convertFromDTO(dto)).thenReturn(income);
		when(incomeRepository.save(income)).thenReturn(income);
		
		
		IncomeDTO dto1111 = incomeService.save(dto);

		verify(rentACarServiceRepository, times(1)).findById(2l);
        verify(incomeConverter, times(1)).convertFromDTO(dto);
        verify(incomeRepository, times(1)).save(income);
		
		
	}

}
