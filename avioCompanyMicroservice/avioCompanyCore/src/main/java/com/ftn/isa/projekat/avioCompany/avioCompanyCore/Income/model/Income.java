package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Income.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model.AvioCompany;

import lombok.Data;

@Entity
@Table (name = "income")
@Data
public class Income
{ //kad je many to one imamo samo taj jedan, kad je one to many imamo listu tih many stavki u toj klasi u kojoj smo to naveli
	//kod many to one ide spajanje po koloni ili tabeli
	//za one to many ne ide spajanje nikakvo, samo mapiranje
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "value")
	private int value;
	
	@Column (name = "income_date")
	private LocalDateTime incomeDate;
	
	@Column (name = "tickets_number")
	private int ticketsNumber;
	
	/*
	 * Related company
	 */
	@JsonIgnore
	@OneToOne (mappedBy = "income", cascade = CascadeType.ALL, orphanRemoval = true) 
	private AvioCompany companyId; 
	
	
	
	
}
