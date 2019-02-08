package com.ftn.isa.projekat.rentACar.rentACarCore.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
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
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.BranchOfficeDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.RentACarServiceDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.repository.BranchOfficeRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.service.BranchOfficeServiceImpl;
import com.ftn.isa.projekat.rentACar.rentACarCore.constants.BranchOfficeConstants;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOBranchOfficeConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.repository.RentACarServiceRepository;





@RunWith(SpringRunner.class)
@SpringBootTest
public class BranchOfficeServiceTest {
	
	@Mock 
	private BranchOfficeRepository branchOfficeRepositoryMock;
	
	
	@Mock
	DTOBranchOfficeConverter branchOfficeConverter;
	
	@Mock
	BranchOffice branchOffice;
	

	
	
	//other
	
	@Mock
	private RentACarServiceRepository rentRepositoryMock;
	
	
	
	@InjectMocks
	private BranchOfficeServiceImpl branchOfficeService;
	
	@Test
	public void testFindAll() {
		when(branchOfficeRepositoryMock.findAll()).thenReturn(Arrays.asList(new BranchOffice()));
		when(branchOfficeConverter.convertToDTO(branchOffice)).thenReturn(new BranchOfficeDTO());
		List<BranchOfficeDTO> branchOffices = branchOfficeService.findAll();
		assertThat(branchOffices).hasSize(1);
		
		
		verify(branchOfficeRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(branchOfficeRepositoryMock);
	}
	
	
	@Test
	public void testfindOneById() {
		BranchOfficeDTO dto = new BranchOfficeDTO();
		dto.setId(5l);
		
		when(branchOfficeRepositoryMock.findById(2l)).thenReturn(Optional.of(branchOffice));
		when(branchOfficeConverter.convertToDTO(branchOffice)).thenReturn(dto);
		BranchOfficeDTO foundObject = branchOfficeService.findOneById(BranchOfficeConstants.BRANCH_OFFICE_ID);
	
		assertEquals(foundObject,dto);
        verify(branchOfficeRepositoryMock, times(1)).findById(2l);
        verifyNoMoreInteractions(branchOfficeRepositoryMock);

	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSave() {
		
		when(branchOfficeRepositoryMock.findAll()).thenReturn(Arrays.asList(new BranchOffice()));
		
		BranchOffice bean = new BranchOffice();
		bean.setId(2l);
		
		when(rentRepositoryMock.findById(3l)).thenReturn(Optional.of(new RentACarService()));
		when(branchOfficeRepositoryMock.save(bean)).thenReturn(bean);
		when(branchOfficeConverter.convertToDTO(branchOffice)).thenReturn(new BranchOfficeDTO());

		
		int dbSizeBeforeAdd = branchOfficeService.findAll().size();
		
		BranchOfficeDTO dtoToSave = new BranchOfficeDTO();
		RentACarServiceDTO rentDTO = new RentACarServiceDTO();
		rentDTO.setId(3l);
		dtoToSave.setRentServiceDTO(rentDTO);
		
		when(branchOfficeConverter.convertFromDTO(dtoToSave)).thenReturn(bean);
		
		BranchOfficeDTO dbBean = branchOfficeService.save(dtoToSave);
		assertThat(dbBean.getId()).isNotNull();
		
		when(branchOfficeRepositoryMock.findAll()).thenReturn(Arrays.asList(new BranchOffice(), bean));
		when(branchOfficeConverter.convertToDTO(branchOffice)).thenReturn(new BranchOfficeDTO());

		List<BranchOfficeDTO> beans = branchOfficeService.findAll();
        assertThat(beans).hasSize(dbSizeBeforeAdd + 1);
                
        verify(branchOfficeRepositoryMock, times(2)).findAll();
        verify(branchOfficeRepositoryMock, times(1)).save(bean);
					
		
	}
	


	

}
