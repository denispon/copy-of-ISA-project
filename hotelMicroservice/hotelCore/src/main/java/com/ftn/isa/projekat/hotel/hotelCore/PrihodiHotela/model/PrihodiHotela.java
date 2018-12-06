package com.ftn.isa.projekat.hotel.hotelCore.PrihodiHotela.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.model.Hotel;

import lombok.Data;

@Entity
@Table (name="prihodi_hotela")
@Data

public class PrihodiHotela {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	@Column (name="income", nullable=false)
	private int income;
	
	@Column (name="incomeDate", nullable=false)
	private Date incomeDate;
	
	@Column (name="brojIznajmljivanja", nullable=false)
	private int brojIznajmljivanja;
	
	@JsonIgnore
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn (name="hotel_id",nullable = false)
	private Hotel hotel_prihodiHotela;
	
}
