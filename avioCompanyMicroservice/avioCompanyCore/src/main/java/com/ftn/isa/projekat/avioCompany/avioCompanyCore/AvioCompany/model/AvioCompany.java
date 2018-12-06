package com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.model.AvioIncome;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.model.Destination;

import lombok.Data;

@Entity
@Table (name="avio_company")
@Data
public class AvioCompany 
{
	@Id
	@Column(name = "id")
	private String id;
	
	@Column (name = "name")
	private String name;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "description")
	private String description;
	
	/*
	 * Income of aviocompany
	 */
	@JsonIgnore
	@OneToMany (mappedBy = "avioCompanyIncome")
	private List<AvioIncome> avioIncomes;
	
	/*
	 * List of destinations for aviocompany
	 */
	@JsonIgnore
	@ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable (name = "company_destinations", joinColumns = {
			@JoinColumn(name = "destination_id")
	}, inverseJoinColumns = {
			@JoinColumn(name = "avio_company_id")
	})
	private List<Destination> companyDestinations;
	
	
	
	
	
}
