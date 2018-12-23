package com.ftn.isa.projekat.purchases.purchasesCore.carRating.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CarRating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "user_id")
	private Long userId;
	
	@Column (name = "car_id")
	private Long carId;

}
