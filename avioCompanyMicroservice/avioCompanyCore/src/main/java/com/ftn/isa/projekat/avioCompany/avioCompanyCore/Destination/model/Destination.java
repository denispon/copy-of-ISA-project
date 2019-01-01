package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	@Column (name = "start_point", nullable = false)
	private String startPoint;
	
	@Column (name = "end_point", nullable = false)
	private String endPoint;
	
	/*
	 * List of flights that takeoff or lands in these destinations
	 */
	@JsonIgnore
	@OneToMany (mappedBy = "flightsDestination")
	private List<Flight> listOfFlights;
	
	/*
	 * List of aviocompanies that uses these destinations
	 */
	@JsonIgnore
	@ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "companyDestinations")
	private List<AvioCompany> listOfDestinations;
	
	
	
	
	
}
