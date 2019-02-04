package com.ftn.isa.projekat.purchases.purchasesCore.ticketRating.service;

import java.util.List;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.TicketRatingDTO;

public interface ITicketRatingService {

	TicketRatingDTO findOneById(Long id);

	List<TicketRatingDTO> findAll();

	TicketRatingDTO save(TicketRatingDTO dto);

	TicketRatingDTO deleteById(Long id);

	TicketRatingDTO changeTicketRating(Long id, TicketRatingDTO ticketRatingDto);

}
