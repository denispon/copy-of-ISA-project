package com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvioIncomeDTO 
{
	int income;
	Date dateOfIncome;
	int purchasedTicketsNum;
	
	AvioCompanyDTO company;
}
