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

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarDTO;


@FeignClient(name="carClient", url = "http://localhost:8090/api/rentacar/car")
public interface CarClient {


	@GetMapping("/{id}")
	public CarDTO getOneCarById (@PathVariable("id") Long id);
	
	@GetMapping("/all")
	public List<CarDTO> getAllCars();
	
	@PostMapping("/")
	public CarDTO addCar(@RequestHeader("Role") String role,@RequestBody CarDTO dto);
	
	@DeleteMapping("/{id}")
	public CarDTO deleteCar(@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	@PutMapping("/{id}")
	public CarDTO changeCar (@RequestHeader("Role") String role,@PathVariable("id") Long id, @RequestBody CarDTO carDto );	
	
	@GetMapping("/getReservedCars/{dateFrom}/{dateTo}")
	public List<CarDTO>  getReservedCarsFromTo(@RequestHeader("Role") String role,@PathVariable("dateFrom") String dateFrom , @PathVariable("dateTo") String dateTo);
	
	@GetMapping("/getFreeCars/{dateFrom}/{dateTo}")
	public List<CarDTO>  getFreeCarsFromTo(@PathVariable("dateFrom") String dateFrom , @PathVariable("dateTo") String dateTo);
}
