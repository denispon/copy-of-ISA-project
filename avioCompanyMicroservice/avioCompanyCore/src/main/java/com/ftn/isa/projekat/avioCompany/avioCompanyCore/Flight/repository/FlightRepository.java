package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.FlightDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>
{
	//pretraga letova OD-DO po datumu
	//ovde za vrednosti kolona idu onako kako se nazivaju u modelu, ne u DTO
	@Query(value = "select f.id, f.avio_company_id, f.flights_destination, f.landing_date, f.take_off_date, f.traveling_time, f.traveling_distance, f.number_of_transfers from flight f, ticket t"
		+ " where f.take_off_date > :takeOffTime and f.landing_date < :landingTime ;", nativeQuery=true)
	Optional<List<Flight>> findFlightsByDate(@Param("takeOffTime") LocalDate takeOffTime, @Param("landingTime") LocalDate landingTime);
	
	//pretraga letova po OD-DO ceni
	@Query(value = "select t.price, f.id, f.avio_company_id, f.flights_destination, f.landing_date, f.take_off_date, f.traveling_time, f.traveling_distance, f.number_of_transfers from flight f, ticket t"
		+ " where t.price > :bottomPrice and t.price < :topPrice ;", nativeQuery = true)
	Optional<List<Flight>> findFlightsByPrice(@Param("bottomPrice") float bottomPrice, @Param("topPrice") float topPrice);
	
	
	/*
	 * Find average rating for one flight (FIX)
	 */
	@Query(value = "SELECT f.id, AVG(rating) FROM ticket, flight f where f.id = :id ;", nativeQuery = true)
	float findAverageRating(@Param("id") Long id);
}
