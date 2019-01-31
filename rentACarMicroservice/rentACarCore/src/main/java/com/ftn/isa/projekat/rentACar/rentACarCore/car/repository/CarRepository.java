package com.ftn.isa.projekat.rentACar.rentACarCore.car.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;

public interface CarRepository extends JpaRepository < Car, Long > {

	@Query(value = "select c.id, c.registration_licence, c.rent_price,"
			+ " c.rent_a_car_service_id, c.car_type_id from car c,"
			+ "reserved_cars rs, reservation r  where c.id = rs.car_id and"
			+ " rs.reservation_id= r.id "
			+ "and r.date_from > :dateFrom AND r.date_to < :dateTo ;", nativeQuery = true)
	Optional< List<Car> > findReservedCars(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo);

	
	@Query(value = "select * from car c where c.id not in "
			+ "(select cc.id from car cc,reserved_cars rs, reservation r where cc.id = rs.car_id and "
			+ "rs.reservation_id= r.id "
			+ "and r.date_from > :dateFrom AND r.date_to < :dateTo );", nativeQuery = true)
	Optional< List<Car> > findFreeCars(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo);


	Optional< List<Car> > findAllByCarRentServiceId(Long rentId);

	@Query(value="select * from car where id in"
			+ " (select car_on_discount_id from car_discounts "
			+ "where date_from <= :date and date_to >= :date);" 
			,nativeQuery=true)
	Optional< List<Car> > findAllCurrentlyOnDiscount(LocalDate date);
	
	
	@Query(value="select * from car where id not in"
			+ " (select car_on_discount_id from car_discounts "
			+ "where date_from <= :date and date_to >= :date);" 
			,nativeQuery=true)
	Optional< List<Car> > findAllNotOnDiscount(LocalDate date);

	
	
	@Query(value="select * from car where id in"
			+ " (select car_on_discount_id from car_discounts);"
			,nativeQuery=true)
	Optional<List<Car>> findAllOnDiscount();



	
}
