package com.ftn.isa.projekat.rentACar.rentACarCore.car.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.rentACar.rentACarCore.carType.model.CarType;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;
import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.model.Reservation;

import lombok.Data;

@Entity
@Table (name="car")
@Data
public class Car {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	@Column (name="registration_licence",nullable = false, unique=true)
	private String registrationLicence;
	
	@Column (name="rent_price" ,nullable = false)
	private int rentPrice;
	
	
	@JsonIgnore
	@ManyToOne ( cascade=CascadeType.ALL )
	@JoinColumn ( name = "rent_a_car_service_id",nullable = false)
	private RentACarService carRentService;
	
	@JsonIgnore
	@ManyToOne ( cascade=CascadeType.ALL )
	@JoinColumn (name="car_type_id")
	private CarType carType;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST , CascadeType.MERGE}, mappedBy = "reservedCars")
	private List<Reservation> carReservations;
	
	
	
}
