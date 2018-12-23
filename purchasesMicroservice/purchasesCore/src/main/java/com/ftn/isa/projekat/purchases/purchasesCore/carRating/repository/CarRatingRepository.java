package com.ftn.isa.projekat.purchases.purchasesCore.carRating.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.isa.projekat.purchases.purchasesCore.carRating.model.CarRating;


public interface CarRatingRepository extends JpaRepository < CarRating , Long > {
	
	Optional<CarRating> findByUserId(Long id);

}
