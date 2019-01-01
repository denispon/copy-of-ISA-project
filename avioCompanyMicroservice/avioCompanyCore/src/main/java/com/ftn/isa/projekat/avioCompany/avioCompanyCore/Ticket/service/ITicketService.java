package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.service;

import java.util.List;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.TicketDTO;

public interface ITicketService {

	TicketDTO findOneById(Long id);

	List<TicketDTO> findAll();

	TicketDTO save(TicketDTO dto);

	TicketDTO deleteById(Long id);

	TicketDTO changeTicket(Long id, TicketDTO ticketDTO);


}
