package com.ftn.isa.projekat.purchases.purchasesCore.rentACarRating.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ftn.isa.projekat.purchases.purchasesCore.rentACarRating.model.RentACarRating;


public interface RentACarRatingRepository extends JpaRepository < RentACarRating , Long > {

	Optional<RentACarRating> findByUserId(Long userId);

	@Query(value="select avg(rating) from rent_a_car_rating "
			+ "where date > :dateFrom and date < :dateTo and rent_a_car_id = :rentServiceId ;\r\n",nativeQuery=true)
	Optional<Double> getAverageRating(Long rentServiceId, LocalDate dateFrom, LocalDate dateTo);

}
