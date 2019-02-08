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

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.RentACarServiceDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTORentACarServiceConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.repository.RentACarServiceRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.service.RentACarServiceServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentACarServiceServiceTest {
	
	@Mock
	RentACarServiceRepository rentACarServiceRepository;
	
	@Mock
	DTORentACarServiceConverter rentACarServiceConverter;
	
	@InjectMocks 
	RentACarServiceServiceImpl rentService;
	
	@Mock
	RentACarService rent;
	
	@Test
	public void testFindAll() {
		when(rentACarServiceRepository.findAll()).thenReturn(Arrays.asList(new RentACarService()));
		when(rentACarServiceConverter.convertToDTO(rent)).thenReturn(new RentACarServiceDTO());
		List<RentACarServiceDTO> rents = rentService.findAll();
		assertThat(rents).hasSize(1);
		
		
		verify(rentACarServiceRepository, times(1)).findAll();
        verifyNoMoreInteractions(rentACarServiceRepository);
	}
	
	@Test
	public void testfindOneById() {
		RentACarServiceDTO dto = new RentACarServiceDTO();
		dto.setId(5l);
		
		when(rentACarServiceRepository.findById(2l)).thenReturn(Optional.of(rent));
		when(rentACarServiceConverter.convertToDTO(rent)).thenReturn(dto);
		RentACarServiceDTO foundObject = rentService.findOneById(2l);
	
		assertEquals(foundObject,dto);
        verify(rentACarServiceRepository, times(1)).findById(2l);
        verifyNoMoreInteractions(rentACarServiceRepository);

	}
	
	@Test
	public void testSumOfIncomes() {
		
		String dateFrom = "1000-10-10T00:00:00";
		String dateTo = "2000-10-10T00:00:00";
		Long rentId = 2l;
		
		when(rentACarServiceRepository.findSumOfIncomes(rentId,LocalDateTime.parse(dateFrom), LocalDateTime.parse(dateTo))).thenReturn(Optional.of(10));
		Integer suma = rentService.getSumOfIncomes(rentId, LocalDateTime.parse(dateFrom), LocalDateTime.parse(dateTo));
		

        verify(rentACarServiceRepository, times(1)).findSumOfIncomes(rentId,LocalDateTime.parse(dateFrom), LocalDateTime.parse(dateTo));
        verifyNoMoreInteractions(rentACarServiceRepository);	
		
	}
	
	
	@Test
	public void testSave() {
		
		RentACarServiceDTO dto = new RentACarServiceDTO();
		
		dto.setId(-1l);
		
		when(rentACarServiceConverter.convertFromDTO(dto)).thenReturn(rent);
		when(rentACarServiceRepository.save(rent)).thenReturn(rent);
		
		RentACarServiceDTO dto1 = rentService.save(dto);
		
		
	   verify(rentACarServiceConverter, times(1)).convertFromDTO(dto);
       verify(rentACarServiceRepository, times(1)).save(rent);
			
	}
	

}
