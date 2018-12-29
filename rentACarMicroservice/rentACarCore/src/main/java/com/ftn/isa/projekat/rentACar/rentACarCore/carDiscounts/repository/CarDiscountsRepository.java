package com.ftn.isa.projekat.rentACar.rentACarCore.carDiscounts.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ftn.isa.projekat.rentACar.rentACarCore.carDiscounts.model.CarDiscounts;

public interface CarDiscountsRepository extends JpaRepository<CarDiscounts, Long>  {

	@Query(value="select * from car_discounts where car_on_discount_id = :idCar AND ("
			+ "(date_from < :dateFrom AND date_to > :dateTo) OR"
			+ "(date_from > :dateFrom AND date_to > :dateTo) OR"
			+ "(date_from < :dateFrom AND date_to < :dateTo)"
			+ ");",nativeQuery=true)
	Optional<List<CarDiscounts>> findCarDiscountByDate(Long idCar, LocalDate dateFrom, LocalDate dateTo);
	
}
