package com.ftn.isa.projekat.hotel.hotelCore.Hotel.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.model.CenovnikUsluga;
import com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.model.HotelskaSoba;
import com.ftn.isa.projekat.hotel.hotelCore.PrihodiHotela.model.PrihodiHotela;
import com.ftn.isa.projekat.hotel.hotelCore.VanredneCeneNocenja.model.VanredneCeneNocenja;

import lombok.Data;

@JsonComponent
@Entity
@Table (name="hotel")
@Data //postavlja gettere i settere
public class Hotel {
	
	@Id //kazemo da je id 
	@GeneratedValue (strategy=GenerationType.IDENTITY) //generisemo id
	@Column (name="id") //ime kolone
	private Long id;
	
	@Column (name="name", nullable=false)
	private String name;
	
	@Column (name="adress", nullable=false)
	private String adress;
	
	@Column (name="promotionalDescription")
	private String promotionalDescription;
	
	@JsonIgnore
	@OneToMany (mappedBy="hotel_prihodiHotela")
	private List<PrihodiHotela> prihodiHotelaList;
	
	@JsonIgnore
	@OneToMany (mappedBy="hotel_hotelskeSobe")
	private List<HotelskaSoba> sobeHotelaList;
	
	@JsonIgnore
	@OneToMany (mappedBy="hotel_vandredneCeneNocenja")
	private List<VanredneCeneNocenja> vanredneCeneNocenjaList;
	
	@JsonIgnore
	@OneToOne (mappedBy="hotel_cenovnikUsluga")
	private CenovnikUsluga cenovnikUsluga;
	

}
