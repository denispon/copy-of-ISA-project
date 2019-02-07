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

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.RentACarServiceDTO;


@FeignClient(name="rentACarServiceClient", url = "http://localhost:8090/api/rentacar/rentACarService")
public interface RentACarServiceClient {

	@GetMapping("/{id}")
	public RentACarServiceDTO getOneRentACarServiceById (@PathVariable("id") Long id);
	
	@GetMapping("/all")
	public List<RentACarServiceDTO> getAllRentACarServices();
	
	@PostMapping("/")
	public RentACarServiceDTO addBranchOffice(@RequestHeader("Role") String role,@RequestBody RentACarServiceDTO dto);
	
	@DeleteMapping("/{id}")
	public RentACarServiceDTO deleteRentACarService(@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	@PutMapping("/{id}")
	public RentACarServiceDTO changeRentACarService (@RequestHeader("Role") String role,@PathVariable("id") Long id, @RequestBody RentACarServiceDTO rentACarDto );
	
	@GetMapping("/getSumOfIncomes/{id}/{dateFrom}/{dateTo}")
	public Integer getSumOfIncomes(@RequestHeader("Role") String role,@PathVariable("id") Long rentService,@PathVariable("dateFrom") String dateFrom , @PathVariable("dateTo") String dateTo);
	
	@GetMapping("/getAverageRating/{id}/{dateFrom}/{dateTo}")
	public Double getAverageRating (@PathVariable("id")Long rentService, @PathVariable("dateFrom") String dateFrom, @PathVariable("dateTo") String dateTo);
}
