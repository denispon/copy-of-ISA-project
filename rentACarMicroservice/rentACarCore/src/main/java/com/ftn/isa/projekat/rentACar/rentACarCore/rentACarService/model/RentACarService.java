package com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;
import com.ftn.isa.projekat.rentACar.rentACarCore.income.model.Income;

import lombok.Data;

@Entity
@Table(name="rent_a_car_service")
@Data
public class RentACarService {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	@Column (name="name")
	private String name;
	
	@Column (name = "adress")
	private String adress;
	
	@Column (name = "description")
	private String description;
	
	@JsonIgnore
	@OneToMany (mappedBy="carRentService")
	private List<Car> cars;
	
	@JsonIgnore
	@OneToMany (mappedBy="incomeRentACarservice")
	private List<Income> incomes;
	
	@JsonIgnore
	@OneToMany (mappedBy="branchOfficeService")
	private List<BranchOffice> branchOffices;
	
	
	
	
}
