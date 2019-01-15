package com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.TicketDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.model.Ticket;

@Component
public class DTOTicketConverter
{
	public TicketDTO convertToDto(Ticket bean)
	{
		TicketDTO dto = new TicketDTO();
		
		dto.setId(bean.getId());
		dto.setPrice(bean.getPrice());
		dto.setRating(bean.getRating());
		
		return dto;
	}
	
	public Ticket convertFromDto(TicketDTO dto)
	{
		Ticket bean = new Ticket();
		
		bean.setId(dto.getId());
		bean.setPrice(dto.getPrice());
		bean.setRating(dto.getRating());
		
		return bean;
	}
}
