/*package com.ftn.isa.projekat.rentACar.rentACarCore.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.BranchOfficeDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.repository.BranchOfficeRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.service.IBranchOfficeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BranchOfficeServiceTest {
	
	@Mock 
	private BranchOfficeRepository branchOfficeRepositoryMock;
	
	@InjectMocks
	private IBranchOfficeService branchOfficeService;
	
	@Test
	public void testFindAll() {
		when(branchOfficeRepositoryMock.findAll()).thenReturn(Arrays.asList(new BranchOffice()));
		List<BranchOfficeDTO> branchOffices = branchOfficeService.findAll();
		assertThat(branchOffices).hasSize(1);
		
		
		verify(branchOfficeRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(branchOfficeRepositoryMock);
	}

}*/
