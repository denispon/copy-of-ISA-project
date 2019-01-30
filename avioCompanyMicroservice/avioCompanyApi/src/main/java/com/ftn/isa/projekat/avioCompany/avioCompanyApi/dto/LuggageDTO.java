package com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto;

import java.util.List;

import javax.print.attribute.standard.Destination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LuggageDTO
{
	private Long id;
	private float weight;
	private int width;
	private int height;
	private int length;
	
	private TicketDTO ticket;
}
