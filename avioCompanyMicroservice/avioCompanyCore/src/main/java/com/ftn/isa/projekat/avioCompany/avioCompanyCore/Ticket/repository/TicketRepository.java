package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> 
{

}
