package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.model.Flight;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.PlaceInPlane.model.PlaceInPlane;

import lombok.Data;

@Entity
@Table (name = "ticket")
@Data
public class Ticket
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "price")
	private float price;
	
	@Column (name = "rating") 
	private int rating;
	
	/*
	 * Flight where this ticket is bought
	 */
	@JsonIgnore
	@ManyToOne ()
	@JoinColumn (name = "flight_ticket")
	private Flight flightTicket;
	
	/*
	 * One place in plane eq exactly one ticket
	 */
	@JsonIgnore
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "place_id")
	private PlaceInPlane place;
	
}
