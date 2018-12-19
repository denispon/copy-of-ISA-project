package com.ftn.isa.projekat.rentACar.rentACarApi.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.ReservationDTO;



@FeignClient(name="reservationClient", url = "http://localhost:8090/api/rentacar/reservation")
public interface ReservationClient {

	
	@GetMapping("/{id}")
	public ReservationDTO getOneReservationById (@PathVariable("id") Long id);
	
	@GetMapping("/all")
	public List<ReservationDTO> getAllReservations();
	
	@PostMapping("/")
	public ReservationDTO addReservation(@RequestBody ReservationDTO dto);
	
	@DeleteMapping("/{id}")
	public ReservationDTO deleteReservation(@PathVariable("id") Long id);
	
	@PutMapping("/{id}")
	public ReservationDTO changeReservation (@PathVariable("id") Long id, @RequestBody ReservationDTO reservationDTO );
	
	@PutMapping("/rate/{id}/{rating}")
	public ReservationDTO rateReservation (@PathVariable("id") Long id, @PathVariable("rating") int rating);
	
	@PutMapping("/rateCar/{id}/{rating}")
	public ReservationDTO rateCar (@PathVariable("id") Long id, @PathVariable("rating") int rating);
	
}
