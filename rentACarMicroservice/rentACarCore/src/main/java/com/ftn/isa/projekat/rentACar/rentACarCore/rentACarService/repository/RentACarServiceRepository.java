package com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;


public interface RentACarServiceRepository extends JpaRepository< RentACarService , Long> {

}
