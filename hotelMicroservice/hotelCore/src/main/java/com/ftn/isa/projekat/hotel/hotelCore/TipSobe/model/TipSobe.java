package com.ftn.isa.projekat.hotel.hotelCore.TipSobe.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.model.HotelskaSoba;
import com.ftn.isa.projekat.hotel.hotelCore.VanredneCeneNocenja.model.VanredneCeneNocenja;

import lombok.Data;

@Entity
@Table (name="tip_sobe")
@Data 

public class TipSobe {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	@Column (name="roomType", nullable=false)
	private String roomType;
	
	@Column (name="nocenjePrice", nullable=false)
	private int nocenjePrice;
	
	@Column (name="polupansionPrice", nullable=false)
	private int polupansionPrice;
	
	@Column (name="pansionPrice", nullable=false)
	private int pansionPrice;
	
	@JsonIgnore
	@OneToMany (mappedBy="tipSobe_hotelskeSobe")
	private List<HotelskaSoba> hotelskaSoba;
	
	@JsonIgnore
	@OneToOne ()
	@JoinColumn (name="vanredne_cene_nocenja_id",nullable = false)
	private VanredneCeneNocenja vanredneCeneNocenja_tipSobe;
}
