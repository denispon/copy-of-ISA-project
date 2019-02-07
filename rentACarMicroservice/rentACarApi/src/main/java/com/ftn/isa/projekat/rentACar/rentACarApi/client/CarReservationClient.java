package com.ftn.isa.projekat.rentACar.rentACarApi.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarReservationDTO;



@FeignClient(name="reservationClient", url = "http://localhost:8090/api/rentacar/reservation")
public interface CarReservationClient {

	
	@GetMapping("/{id}")
	public CarReservationDTO getOneReservationById (@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	@GetMapping("/all")
	public List<CarReservationDTO> getAllReservations(@RequestHeader("Role") String role);
	
	@PostMapping("/")
	public CarReservationDTO addReservation(@RequestHeader("Role") String role,@RequestBody CarReservationDTO dto);
	
	@DeleteMapping("/{id}")
	public CarReservationDTO deleteReservation(@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	@PutMapping("/{id}")
	public CarReservationDTO changeReservation (@RequestHeader("Role") String role,@PathVariable("id") Long id, @RequestBody CarReservationDTO reservationDTO );
	
	
}
