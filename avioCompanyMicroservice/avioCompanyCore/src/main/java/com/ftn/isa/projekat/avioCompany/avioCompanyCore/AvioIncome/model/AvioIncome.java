package com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.model;

import java.sql.Date;

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
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model.AvioCompany;

import lombok.Data;

@Entity
@Table (name = "avio_income")
@Data
public class AvioIncome
{ //kad je many to one imamo samo taj jedan, kad je one to many imamo listu tih many stavki u toj klasi u kojoj smo to naveli
	//kod many to one ide spajanje po koloni ili tabeli
	//za one to many ne ide spajanje nikakvo, samo mapiranje
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "income")
	private float income;
	
	@Column (name = "income_date")
	private Date incomeDate; //mozda treba da bude util.Date
	
	@Column (name = "tickets_number")
	private int ticketsNumber;
	
	/*
	 * Stores a income of all aviocompanies so far
	 */
	@JsonIgnore
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "avio_company_id")
	private AvioCompany avioCompanyIncome; //ovo je strani kljuc
	//jedan prihod moze da ima samo jednu avio kompaniju
	
	
	
	
}
