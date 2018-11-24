package com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.IncomeDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.income.model.Income;

public class DTOIncomeConverter {

	public IncomeDTO convertToDTO (Income income) {
		
		IncomeDTO dto = new IncomeDTO();
		
		dto.setDate(income.getDate());
		dto.setId(income.getId());
		dto.setNumberOfCars(income.getNumberOfCars());
		dto.setRentIncome(income.getRentIncome());
		
		return dto;

	}
	
	
	public Income convertFromDTO (IncomeDTO incomeDTO) {
		
		Income bean = new Income();
		
	//	bean.setDate(incomeDTO.getDate());
		bean.setId(incomeDTO.getId());
		bean.setNumberOfCars(incomeDTO.getNumberOfCars());
		bean.setRentIncome(incomeDTO.getRentIncome());
		//fali rentACarService
		
		return bean;
		
	}
}
