package com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvioCompanyDTO
{
	String name;
	String address;
	String promotionalDesc;
	
}
