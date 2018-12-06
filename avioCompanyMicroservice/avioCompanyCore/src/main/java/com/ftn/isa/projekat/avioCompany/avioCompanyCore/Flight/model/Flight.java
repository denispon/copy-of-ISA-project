package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.model;

import java.sql.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.model.Destination;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.PlaceInPlane.model.PlaceInPlane;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.model.Ticket;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.TransferLocation.model.TransferLocation;

import lombok.Data;

@Entity
@Table (name = "flight")
@Data
public class Flight
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "take_off_date")
	private Date takeOffDate; //poletanje
	
	@Column (name = "langing_date")
	private Date langingDate; //sletanje
	
	@Column (name = "traveling_time")
	private Date travelingTime;
	
	@Column (name = "traveling_distance")
	private float travelingDistance;
	
	@Column (name = "number_of_transfers") //broj presedanja
	private int numberOfTransfers;
	
	/*
	 * List of destinations that support specified flight
	 */
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "flights_destination")
	private Destination flightsDestination;
	
	/*
	 * List of locations where transfer is possible
	 */
	@JsonIgnore
	@ManyToMany (fetch = FetchType.LAZY, cascade = {
			CascadeType.PERSIST, CascadeType.MERGE
	})
	@JoinTable(name = "places_for_transfer", joinColumns = {
			@JoinColumn(name = "transfer_location_id")
	}, inverseJoinColumns = {
			@JoinColumn(name = "flight_id")
	})
	private List<TransferLocation> flightTransfers;
	
	/*
	 * List of tickets for flight
	 */
	@JsonIgnore
	@OneToMany (mappedBy = "flightTicket")
	private List<Ticket> tickets;
	
	/*
	 * List of places in plane available on flight
	 */
	@JsonIgnore
	@OneToMany (mappedBy = "flightPlace")
	private List<PlaceInPlane> places;

}
