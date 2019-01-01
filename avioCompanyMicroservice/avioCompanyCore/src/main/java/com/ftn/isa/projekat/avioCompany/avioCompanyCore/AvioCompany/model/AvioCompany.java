package com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model;

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
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.model.AvioIncome;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.model.Destination;

import lombok.Data;
import lombok.Getter;

@Entity
@Table (name="avio_company")
@Data
public class AvioCompany 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //kad ovde stavim AUTO i id koji ne postoji, on napravi torku i ubaci je u bazu pod narednim
	//sledecim id-jem koji treba da bude, ne sa tim koji sam naznacio - bilo je identity
	@Column(name = "id")
	private Long id;
	
	@Column (name = "name", nullable = false)
	private String name;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "description")
	private String description;
	
	/*
	 * Income of aviocompany
	 */
	@JsonIgnore
	@OneToMany (mappedBy = "companyId", cascade = CascadeType.ALL) //bez ovog mapped by bi se kreirala medjutabela koja bi sadrzala id jedne i druge klase
	private List<AvioIncome> avioIncomes;
	
	/*
	 * List of destinations for aviocompany
	 */
	@JsonIgnore
	@ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	//cascadeType.all je jaka veza, dakle sta god referentni entitet da uradi ovaj povezani ce da ga isprati (ako se obrise jedna kompanija - brise se i jedna torka iz prihoda koja je referencirala tu kompaniju)
	@JoinTable (name = "company_destinations", joinColumns = {
			@JoinColumn(name = "destination_id")
	}, inverseJoinColumns = {
			@JoinColumn(name = "avio_company_id")
	})
	private List<Destination> companyDestinations;
	
	public AvioCompany(String name, String add, String desc)
	{
		this.name = name;
		this.address = add;
		this.description = desc;
	}

	public AvioCompany()
	{
		
	}
	
	
}
