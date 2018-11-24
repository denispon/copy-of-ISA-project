package com.ftn.isa.projekat.rentACar.rentACarCore.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.model.Reservation;

public interface ReservationRepository extends JpaRepository< Reservation, Long>{

}
