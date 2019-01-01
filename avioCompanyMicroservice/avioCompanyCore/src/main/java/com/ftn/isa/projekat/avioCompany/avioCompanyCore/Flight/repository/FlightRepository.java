package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>
{

}
