package com.ftn.isa.projekat.avioCompany.avioCompanyCore.PlaceInPlane.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.model.Flight;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.model.Ticket;

import lombok.Data;

@Entity
@Table (name = "place_in_plane")
@Data
public class PlaceInPlane
{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "serial_number")
	private int serialNumber;
	
	@Column (name = "occupied")
	private boolean occupied;
	
	/*
	 * Flight that takes specified number of places
	 */
	@JsonIgnore
	@ManyToOne ()
	@JoinColumn (name = "flight_place", nullable = true)
	private Flight flightPlace;
	
	/*
	 * One place in plane eq exactly one ticket
	 */
	@JsonIgnore
	@OneToOne (mappedBy = "place", cascade = CascadeType.ALL)
	private Ticket ticketForPlace;
}
