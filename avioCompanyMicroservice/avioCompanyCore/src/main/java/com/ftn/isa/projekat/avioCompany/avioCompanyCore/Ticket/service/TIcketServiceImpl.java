package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.TicketDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.model.Ticket;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.repository.TicketRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOTicketConverter;

@Service
public class TIcketServiceImpl implements ITicketService
{
	@Autowired
	TicketRepository repository;
	
	@Autowired
	DTOTicketConverter converter;

	@Override
	public TicketDTO findOneById(Long id)
	{
		Optional<Ticket> ticket = repository.findById(id);
		
		if(ticket.isPresent())
			return converter.convertToDto(ticket.get());
		else
			return new TicketDTO();
	}

	@Override
	public List<TicketDTO> findAll()
	{
		Optional<List<Ticket>> list = Optional.of(repository.findAll());
		ArrayList<TicketDTO> dtos = new ArrayList<TicketDTO>();
		
		if(list.isPresent())
		{
			for(Ticket tick : list.get())
			{
				dtos.add(converter.convertToDto(tick));
			}
			
			return dtos;
		}
		
		return Collections.emptyList();
	}

	@Override
	public TicketDTO save(TicketDTO dto) 
	{
		repository.save(converter.convertFromDto(dto));
		
		return dto;
	}

	@Override
	public TicketDTO deleteById(Long id)
	{
		Optional<Ticket> toDel = repository.findById(id);
		
		if(toDel.isPresent())
		{
			repository.deleteById(id);
			return converter.convertToDto(toDel.get());
		}
		
		return null;
	}

	//DOVRSI UPDATE
	@Override
	public TicketDTO changeTicket(Long id, TicketDTO ticketDTO)
	{
		
		return null;
	}

}
