package com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.RentACarServiceDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;
@Component
public class DTORentACarServiceConverter {

	public RentACarServiceDTO convertToDTO (RentACarService service) {
		
		RentACarServiceDTO dto = new RentACarServiceDTO();
		
		dto.setAdress(service.getAdress());
		dto.setDescription(service.getDescription());
		dto.setId(service.getId());
		dto.setName(service.getName());
		
		return dto;
	}
	
	public RentACarService convertFromDTO ( RentACarServiceDTO serviceDTO) {
		
		RentACarService bean = new RentACarService();
		
		bean.setAdress(serviceDTO.getAdress());
		bean.setDescription(serviceDTO.getDescription());
		bean.setName(serviceDTO.getName());
		
		return bean;
	}
}
