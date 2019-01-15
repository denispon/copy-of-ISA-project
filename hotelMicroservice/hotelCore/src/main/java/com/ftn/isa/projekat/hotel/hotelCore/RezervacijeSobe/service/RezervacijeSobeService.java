package com.ftn.isa.projekat.hotel.hotelCore.RezervacijeSobe.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.CenovnikUslugaDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelskaSobaDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.RezervacijeSobeDTO;
import com.ftn.isa.projekat.hotel.hotelCore.CenovnikUsluga.model.CenovnikUsluga;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.model.Hotel;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.repository.HotelRepository;
import com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.model.HotelskaSoba;
import com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.repository.HotelskaSobaRepository;
import com.ftn.isa.projekat.hotel.hotelCore.RezervacijeSobe.model.RezervacijeSobe;
import com.ftn.isa.projekat.hotel.hotelCore.RezervacijeSobe.repository.RezervacijeSobeRepository;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOHotelConverter;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTOHotelskaSobaConverter;
import com.ftn.isa.projekat.hotel.hotelCore.dtoConverter.DTORezervacijeSobeConverter;

@Component
public class RezervacijeSobeService implements IRezervacijeSobeService{
	
	@Autowired
	RezervacijeSobeRepository rezervacijeSobeRepository;
	
	@Autowired
	DTORezervacijeSobeConverter rezervacijeSobeConverter;
	
	@Autowired
	HotelskaSobaRepository hotelskaSobaRepository;
	
	@Autowired
	DTOHotelskaSobaConverter hotelskaSobaConverter;
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	DTOHotelConverter hotelConverter;
	
	public RezervacijeSobeDTO findOneById(Long id) {
		
		Optional<RezervacijeSobe> zaPronalazak=rezervacijeSobeRepository.findById(id);
		
		if(zaPronalazak.isPresent()) {
			return rezervacijeSobeConverter.convertToDTO(zaPronalazak.get());
		}else {
			return new RezervacijeSobeDTO();
		}		
	}
	
	public List<RezervacijeSobeDTO> findAll(){
		Optional<List<RezervacijeSobe>> list = Optional.of(rezervacijeSobeRepository.findAll());
		ArrayList<RezervacijeSobeDTO> arrayDTO = new ArrayList<RezervacijeSobeDTO>();
		if(list.isPresent()) {
			for(RezervacijeSobe item : list.get()) {
				arrayDTO.add(rezervacijeSobeConverter.convertToDTO(item));
			}
			return arrayDTO;
		}
		return Collections.emptyList();
	}
	
	public RezervacijeSobeDTO save(RezervacijeSobeDTO dto) {
		rezervacijeSobeRepository.save(rezervacijeSobeConverter.convertFromDTO(dto));
		return dto;
	}
	
	public RezervacijeSobeDTO deleteById(Long id) {
		
		Optional<RezervacijeSobe> zaBrisanje = rezervacijeSobeRepository.findById(id);
		
		if(zaBrisanje.isPresent()) {
			rezervacijeSobeRepository.deleteById(id);
			return rezervacijeSobeConverter.convertToDTO(zaBrisanje.get());
		}else {
			return new RezervacijeSobeDTO();
		}
		
	}
	
	public RezervacijeSobeDTO change(Long id, RezervacijeSobeDTO dto) {
		
		Optional<RezervacijeSobe> zaIzmenu = rezervacijeSobeRepository.findById(id);
		
		if(zaIzmenu.isPresent() && dto!=null) {
			
			zaIzmenu.get().setDateFrom(dto.getDateFrom());
			zaIzmenu.get().setDateUntil(dto.getDateUntil());
			zaIzmenu.get().setTotalPrice(dto.getTotalPrice());
			//zaIzmenu.get().setHotelskaSoba_rezervacijeSobe(hotelskaSobaConverter.convertFromDTO(dto.getHotelskaSoba_rezervacijeSobe()));
			zaIzmenu.get().setSobaId(dto.getSobaId());
			
			rezervacijeSobeRepository.save(zaIzmenu.get());
			
			dto.setId(zaIzmenu.get().getId());
			
			return dto;
		}
		
		return new RezervacijeSobeDTO();
		
	}
	
	
	public List<HotelskaSobaDTO> getFreeRooms(Long id, Date datumOd, Date datumDo){
		int vecPostoji;
		List<HotelskaSobaDTO> list = new ArrayList<HotelskaSobaDTO>();		
		Optional<List<RezervacijeSobe>> reservationList = Optional.of(rezervacijeSobeRepository.findAll());
		
		if(reservationList.isPresent()) {
			for(RezervacijeSobe rezervacija : reservationList.get()) {//da li soba pripada zadatom hotelu?
				if(rezervacija.getHotel_rezervacijeSobe().getId() == id) {
					if(rezervacija.getDateFrom().before(datumOd) || rezervacija.getDateUntil().after(datumDo)
							|| (rezervacija.getDateFrom().after(datumOd) && rezervacija.getDateUntil().before(datumDo))) {
						continue;
					}else {
						if(!list.isEmpty()) {
							vecPostoji = 0;
							for(int i = 0; i<list.size(); i++) {
								if(list.get(i).getId()==rezervacija.getSobaId()) {
									vecPostoji = 1;
									break;
								}
							}
							if(vecPostoji!=1) {
								list.add(hotelskaSobaConverter.convertToDTO(hotelskaSobaRepository.findById(rezervacija.getSobaId()).get()));
							}
						}else {
							list.add(hotelskaSobaConverter.convertToDTO(hotelskaSobaRepository.findById(rezervacija.getSobaId()).get()));
						}
					}
				}
			}
			return list;
		}

		return Collections.emptyList();
	}
	//uzmem sve rezervacije u koje ulazi datum i gledam koje su to sobe i njih ne ispisujem
	/*public RezervacijeSobeDTO save(RezervacijeSobeDTO dto) {
		rezervacijeSobeRepository.save(rezervacijeSobeConverter.convertFromDTO(dto));
		return dto;
	}*/
	
}
