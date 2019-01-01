package com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceInPlaneDTO
{
	private Long id;
	private int serialNum;
	private boolean reserved;
}
