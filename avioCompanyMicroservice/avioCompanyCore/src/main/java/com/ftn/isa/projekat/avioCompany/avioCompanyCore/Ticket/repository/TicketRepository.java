package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> 
{
	//ne radi average
	@Query(value = "SELECT AVG(rate) FROM ticket where id = :id", nativeQuery = true)
	Optional<Float> findAverageRating(Long id);
	
	
}
