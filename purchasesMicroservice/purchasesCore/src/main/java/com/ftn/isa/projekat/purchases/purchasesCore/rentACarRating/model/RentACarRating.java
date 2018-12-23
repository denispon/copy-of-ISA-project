package com.ftn.isa.projekat.purchases.purchasesCore.rentACarRating.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RentACarRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "user_id")
	private Long userId;
	
	@Column (name = "rent_a_car_id")
	private Long rentACarId;
	
}
