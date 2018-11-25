package com.ftn.isa.projekat.rentACar.rentACarCore.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;

public interface CarRepository extends JpaRepository < Car, Long > {

}
