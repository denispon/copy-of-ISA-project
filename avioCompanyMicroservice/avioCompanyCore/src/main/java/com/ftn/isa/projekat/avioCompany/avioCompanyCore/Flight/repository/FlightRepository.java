package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>
{
	//ovde za vrednosti kolona idu onako kako se nazivaju u modelu, ne u DTO
	
	/*
	 * Pretraga letova OD-DO po datumu
	 */
	@Query(value = "select f.id, f.avio_company_id, f.flights_destination, f.landing_date, f.take_off_date, f.traveling_time, f.traveling_distance, f.number_of_transfers from flight f, ticket t"
		+ " where f.take_off_date > :takeOffTime and f.landing_date < :landingTime ;", nativeQuery=true)
	Optional<List<Flight>> findFlightsByDate(@Param("takeOffTime") LocalDateTime takeOffTime, @Param("landingTime") LocalDateTime landingTime);
	
	
	
	
	/*
	 * Find average rating for one flight
	 */
	@Query(value = "select avg(t.rating) FROM ticket t, flight f where f.id = :id ;", nativeQuery = true)
	Optional<Float> findAverageRating(@Param("id") Long id);
}
