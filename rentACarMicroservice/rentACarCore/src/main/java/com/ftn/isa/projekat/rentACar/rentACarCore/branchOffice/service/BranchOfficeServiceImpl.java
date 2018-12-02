package com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.BranchOfficeDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.repository.BranchOfficeRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOBranchOfficeConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTORentACarServiceConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.repository.RentACarServiceRepository;

@Component
public class BranchOfficeServiceImpl implements IBranchOfficeService {

	
	@Autowired
	BranchOfficeRepository branchOfficeRepository;
	@Autowired
	RentACarServiceRepository rentACarServiceRepository;
	
	@Autowired
	DTOBranchOfficeConverter branchOfficeConverter;
	@Autowired
	DTORentACarServiceConverter rentServiceConverter;
	
	
	public BranchOfficeDTO findOneById(Long id) {
		
		Optional <BranchOffice> branchOffice = branchOfficeRepository.findById(id);
		
		
		if (branchOffice.isPresent()) {
			
			return branchOfficeConverter.convertToDTO(branchOffice.get());
		
		}
		else {
			
			return new BranchOfficeDTO();
			
		}
		
	}

	
	public List<BranchOfficeDTO> findAll() {

		Optional< List<BranchOffice> > list = Optional.of(branchOfficeRepository.findAll());
		ArrayList< BranchOfficeDTO > branchOfficesDTO = new ArrayList< BranchOfficeDTO >();
		
		if ( list.isPresent() ) {
			
			for ( BranchOffice branch : list.get()) {
				
				branchOfficesDTO.add(branchOfficeConverter.convertToDTO(branch));
				
			}
			
			return branchOfficesDTO;
			
		}
		
		return Collections.emptyList();
		
	}

	
	public BranchOfficeDTO save(BranchOfficeDTO branchOfficeToSave) {
		
		branchOfficeRepository.save(branchOfficeConverter.convertFromDTO(branchOfficeToSave));
		
		return branchOfficeToSave;
	}

	
	public BranchOfficeDTO deleteById(Long id) {
		
		Optional<BranchOffice> branchOfficeToDelete = branchOfficeRepository.findById(id);
		
		if( branchOfficeToDelete.isPresent() ) {
		
			branchOfficeRepository.deleteById(id);
			return branchOfficeConverter.convertToDTO(branchOfficeToDelete.get());
		
		}
		
		return new BranchOfficeDTO();
		
		
	}

	
	public BranchOfficeDTO changeBranchOffice(Long id, BranchOfficeDTO branchOffice) {
		
		Optional<BranchOffice> branchForChange = branchOfficeRepository.findById(id);
		
		if( branchForChange.isPresent() && branchOffice!=null) {
					
			//setting rentACarService for branchOffice
			Optional<RentACarService> rentService = rentACarServiceRepository.findById(branchOffice.getService().getId());
			
			if(rentService.isPresent()) {
				
				branchForChange.get().setAdress(branchOffice.getAdress());
				branchForChange.get().setName(branchOffice.getName());
				branchForChange.get().setBranchOfficeService(rentService.get());
				
				
				branchOfficeRepository.save(branchForChange.get());
				
				//after branchOffice was saved , we need to put branchs id into dto object
				branchOffice.setId(branchForChange.get().getId());
				
				
				return branchOffice;
				
			}
			 
			
		}
		
		return new BranchOfficeDTO();
	}
	
	
}
