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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.model.Destination;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.model.Flight;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Income.model.Income;

import lombok.Data;

@Entity
@Table (name="aviocompany")
@Data
public class AvioCompany 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //kad ovde stavim AUTO i id koji ne postoji, on napravi torku i ubaci je u bazu pod narednim
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
	 * One airline - one destination
	 */
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destination_id")
	private Destination destination;
	
	/*
	 * List of flights
	 */
	@JsonIgnore
	@OneToMany (mappedBy = "avioCompany", cascade = CascadeType.ALL, orphanRemoval = true) //orphan - kad se obrise ovaj brisu se i letovi (kontam treba ovo jer sam stavio za min kard = 1)
	private List<Flight> flights;
	
	
	/*
	 * Income for one aviocompany
	 */
	@JsonIgnore
	@OneToOne (fetch = FetchType.LAZY) //bez ovog mapped by bi se kreirala medjutabela koja bi sadrzala id jedne i druge klase
	@JoinColumn(name = "income_id")
	private Income income;
	
	
	//************************************************
	
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
