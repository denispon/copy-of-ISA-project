package com.ftn.isa.projekat.purchases.purchasesCore.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.isa.projekat.purchases.purchasesCore.reservation.model.Reservation;


public interface ReservationRepository extends JpaRepository < Reservation , Long > {

}
