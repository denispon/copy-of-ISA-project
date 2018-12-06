package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table (name = "ticket")
@Data
public class Ticket
{
	@Id
	@Column (name = "id")
	private Long id;
	
	@Column (name = "price")
	private float price;
	
	@Column (name = "rate")
	private int rate;
	
	/*
	 * Flight where this ticket is bought
	 */
	@JsonIgnore
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "flight_ticket")
	private Ticket flightTicket;
	
	/*
	 * One place in plane eq exactly one ticket
	 */
	@JsonIgnore
	@OneToOne 
	private Ticket placeTicket;
	
}
