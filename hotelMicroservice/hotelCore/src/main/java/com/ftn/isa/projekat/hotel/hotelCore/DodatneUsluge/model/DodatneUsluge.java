package com.ftn.isa.projekat.hotel.hotelCore.DodatneUsluge.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.model.CenovnikUsluga;

import lombok.Data;

@JsonComponent
@Entity
@Table (name="dodatne_usluge")
@Data 

public class DodatneUsluge {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	@Column (name="additionalServiceName", nullable=false)
	private String additionalServiceName;
	
	@Column (name="additionalServicePrice", nullable=false)
	private int additionalServicePrice;
	
	@JsonIgnore
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn (name="cenovnik_usluga_id", nullable = false)
	private CenovnikUsluga cenovnikUsluga_dodatneUsluge;

}
