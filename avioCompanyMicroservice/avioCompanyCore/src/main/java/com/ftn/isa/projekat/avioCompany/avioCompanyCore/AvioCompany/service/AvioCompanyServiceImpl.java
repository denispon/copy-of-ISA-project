package com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioCompanyDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.FlightDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.TicketDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model.AvioCompany;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.repository.AvioCompanyRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.model.Flight;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.repository.FlightRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.model.Ticket;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Ticket.repository.TicketRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOAvioCompanyConverter;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOFlightConverter;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter.DTOTicketConverter;

@Service
public class AvioCompanyServiceImpl implements IAvioCompanyService
{
	@Autowired
	AvioCompanyRepository companyRepository;
	@Autowired
	DTOAvioCompanyConverter companyConverter;
//	@Autowired
//	AvioIncomeRepository incomerep;
	
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	DTOFlightConverter flightConverter;
	
	@Autowired
	TicketRepository ticketRepository;
	@Autowired 
	DTOTicketConverter ticketConverter;
	
	
	

	@Override
	public AvioCompanyDTO findOneById(Long id)
	{
		Optional<AvioCompany> company = companyRepository.findById(id);
		
		if(company.isPresent())
			return companyConverter.convertToDTO(company.get());
		else
			return new AvioCompanyDTO();
	}

	@Override
	public List<AvioCompanyDTO> findAll() 
	{
		Optional<List<AvioCompany>> list = Optional.of(companyRepository.findAll());
		ArrayList<AvioCompanyDTO> companiesDTO = new ArrayList<AvioCompanyDTO>();
		
		if(list.isPresent())
		{
			for(AvioCompany avio : list.get())
				companiesDTO.add(companyConverter.convertToDTO(avio));
			
			return companiesDTO;
		}
		
		return Collections.emptyList();
		
	}

	@Override
	public AvioCompanyDTO save(AvioCompanyDTO companyToSave)
	{
		companyRepository.save(companyConverter.convertFromDTO(companyToSave));
		
		return companyToSave;
	}

	@Override
	public AvioCompanyDTO deleteById(Long id)
	{
		Optional<AvioCompany> companyToDelete = companyRepository.findById(id);
		
		if(companyToDelete.isPresent())
		{
			companyRepository.deleteById(id);
			return companyConverter.convertToDTO(companyToDelete.get());
		}
		
		return new AvioCompanyDTO();

	}

	@Override
	public AvioCompanyDTO changeAvioCompany(Long id, AvioCompanyDTO avioDto)
	{
		Optional<AvioCompany> companyChange = companyRepository.findById(id);
	
		if(companyChange.isPresent() && avioDto != null)
		{
			companyChange.get().setName(avioDto.getName());
			companyChange.get().setAddress(avioDto.getAddress());
			companyChange.get().setDescription(avioDto.getDescription());
			
			companyRepository.save(companyChange.get());
			
			avioDto.setId(companyChange.get().getId());
			
			return avioDto;
		}
		
		return null;
	}
	
	/*
	 * 
	 * Prosecna ocena za kompaniju
	 */

	@Override
	public Float getAvgRating(Long id) //prosledjujemo ID kompanije za koju trazimo prosecnu sumu
	{
		Optional<List<Flight>> flights = Optional.of(flightRepository.findAll());
		Optional<List<Ticket>> tickets = Optional.of(ticketRepository.findAll());
		
		ArrayList<FlightDTO> flDtos = new ArrayList<FlightDTO>();
		ArrayList<TicketDTO> tDtos = new ArrayList<TicketDTO>();
		
		int flightSum = 0; //zbir svih ocena za jedan let
		float companyAvg = 0; //konacna prosecna ocena kompanije
		
		if(flights.isPresent()) //ako postoji let => znaci da je zavrsen i postoje ocene korisnika
		{
			for(Ticket ticket : tickets.get())
			{
				tDtos.add(ticketConverter.convertToDto(ticket)); //dodajemo karte u spisak karata
			}
			
			for(Flight flight : flights.get())
			{
				flDtos.add(flightConverter.convertToDTO(flight)); //dodajemo letove u spisak letova
			}
			
			int sumTickets = 0; //zbir ocena sa karata
			int nFlights = 0; //koliko puta je nasao let na osnovu karte
			for(FlightDTO fDto : flDtos) 
			{
				for(TicketDTO tDto : tDtos)
				{
					if(!tDto.getFlight().getId().equals(fDto.getId())) 
					{
						continue;
					}
					else
					{
						sumTickets += tDto.getRating(); //sadrzi zbir svih ocena iz karata (za jedan let)
					}
						
				}
				
				//ovaj deo mi se ne svidja, nisam lepo realizovao zbir ocena svih letova za jednu kompaniju
				if(!fDto.getCompany().getId().equals(id))
				{
					continue;
				}
				else
				{//sad mi ovde treba zbir svih ocena sa svih letova jedne kompanije
					flightSum += sumTickets;
					nFlights++;
				}
				
				
		
			}
			companyAvg = flightSum / nFlights;
			System.out.println(companyAvg);
			return companyAvg;
		}
		else	
			return null;
		
			
	}

}
