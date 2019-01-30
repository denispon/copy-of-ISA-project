package com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeDTO 
{
	private Long id;
	private int value;
	private LocalDateTime incomeDate;
	private int ticketsNumnber;
	
	private AvioCompanyDTO companyId; //u react-u odavde treba samo id pozvati (nad ovim objektom), mozda je i logicnije da se samo pozove ovde id al nema veze
}
