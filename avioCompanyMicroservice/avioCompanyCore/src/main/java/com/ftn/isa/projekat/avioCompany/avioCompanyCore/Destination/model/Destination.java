package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model.AvioCompany;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.model.Flight;

import lombok.Data;

@Entity
@Table (name = "destination")
@Data
public class Destination
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "name", nullable = false)
	private String name;
	
	
	/*
	 * AvioCompany
	 */
	@JsonIgnore
	@OneToOne(mappedBy = "destination", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private AvioCompany avioCompany;
	
	
	/*
	 * List of flights that takeoff or lands in these destinations
	 */
	@JsonIgnore
	@OneToOne (mappedBy = "destinationTakeOff", cascade = CascadeType.ALL)
	private Flight flightTakeOff;
	
	/*
	 * List of flights that lands there
	 */
	@JsonIgnore
	@OneToOne (mappedBy = "destinationLanding", cascade = CascadeType.ALL)
	private Flight flightLanding;
	
	
	/*
	 * Flights that includes transfers
	 */
	@ManyToMany(mappedBy = "destinationsForTransfer")
	private List<Flight> flightsWithTransfers;
	
	
	
	
	
	
	
}
