package com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.TransferLocationDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.TransferLocation.model.TransferLocation;

@Component
public class DTOTransferLocationConverter 
{
	public TransferLocationDTO convertToDto(TransferLocation bean)
	{
		TransferLocationDTO dto = new TransferLocationDTO();
		
		dto.setId(bean.getId());
		dto.setNameOfCity(bean.getCityName());
		
		return dto;
	}
	
	public TransferLocation convertFromDto(TransferLocationDTO dto)
	{
		TransferLocation bean = new TransferLocation();
		
		bean.setId(dto.getId());
		bean.setCityName(dto.getNameOfCity());
		
		return bean;
	}
}
