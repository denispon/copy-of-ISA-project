package com.ftn.isa.projekat.rentACar.rentACarCore.carType.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;

import lombok.Data;

@Entity
@Table (name="car_type")
@Data
public class CarType {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	@Column (name="model")
	private String model;
	
	@Column (name="brand")
	private String brand;
	
	@Column (name="model_year")
	private int modelYear;
	
	@Column (name="car_type")
	private String carType;
	
	@Column (name="number_of_seats")
	private int numberOfSeats;
	
	@JsonIgnore
	@OneToMany(mappedBy="carType")
	private List<Car> cars;
}
