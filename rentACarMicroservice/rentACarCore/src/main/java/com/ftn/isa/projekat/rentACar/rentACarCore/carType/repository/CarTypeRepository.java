package com.ftn.isa.projekat.rentACar.rentACarCore.carType.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.rentACar.rentACarCore.carType.model.CarType;

public interface CarTypeRepository extends JpaRepository < CarType , Long > {

}
