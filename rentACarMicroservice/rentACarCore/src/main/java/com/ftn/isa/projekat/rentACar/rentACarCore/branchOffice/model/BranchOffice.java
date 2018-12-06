package com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;
import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.model.Reservation;

import lombok.Data;

@Entity
@Table (name="branch_office")
@Data
public class BranchOffice {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name="name",nullable = false)
	private String name;
	
	@Column (name="adress",nullable = false)
	private String adress;
	
	@JsonIgnore
	@ManyToOne ()
	@JoinColumn (name="rent_a_car_service_id",nullable = false)
	private RentACarService branchOfficeService;
	
	/*
	 * List of reservations which are taken from this branch office
	 * */
	@JsonIgnore
	@OneToMany (mappedBy="branchOfficeFrom")
	private List<Reservation> reservationFromBranchOffice;
	
	/*
	 *List of reservation who has a car who needs to get back to this branch office
	 *
	 *OneToMany mappedBy ide ime one promenljive u kojoj si ubacio taj nas office iz neke klase koja je koristila ovo
	 * */
	@JsonIgnore
	@OneToMany (mappedBy="branchOfficeTo")
	private List<Reservation> reservationToBranchOffice;
}
