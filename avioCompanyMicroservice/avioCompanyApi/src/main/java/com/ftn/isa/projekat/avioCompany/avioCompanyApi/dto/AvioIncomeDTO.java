package com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvioIncomeDTO 
{
	private Long id;
	private int income;
	private Date dateOfIncome;
	private int purchasedTicketsNum;
	
	private AvioCompanyDTO company; //u react-u odavde treba samo id pozvati (nad ovim objektom), mozda je i logicnije da se samo pozove ovde id al nema veze
}
