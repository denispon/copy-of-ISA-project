package com.ftn.isa.projekat.avioCompany.avioCompanyCore.TransferLocation.model;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.model.Flight;

import lombok.Data;

@Entity
@Table (name = "transfer_location")
@Data
public class TransferLocation
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column (name = "city_name")
	private String cityName;
	
	/*
	 * List of flights where transfer is executed
	 */
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST , CascadeType.MERGE}, mappedBy = "flightTransfers")
	private List<Flight> flightsForTransfer;
	
	
}
