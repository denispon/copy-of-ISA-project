package com.ftn.isa.projekat.purchases.purchasesCore.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="reservation")
public class Reservation {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	

	@Column (name = "user_id")
	private Long userId;
	
	
	@Column (name = "carReservation_id")
	private Long carReservationId;
	
	
}
