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

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.IncomeDTO;


@FeignClient(name="incomeClient", url = "http://localhost:8090/api/rentacar/income")
public interface IncomeClient {
	
	@GetMapping("/{id}")
	public IncomeDTO getOneIncomeById (@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	@GetMapping("/all")
	public List<IncomeDTO> getAllIncomes(@RequestHeader("Role") String role);
	
	@PostMapping("/")
	public IncomeDTO addIncome(@RequestHeader("Role") String role,@RequestBody IncomeDTO dto);
	
	@DeleteMapping("/{id}")
	public IncomeDTO deleteIncome(@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	@PutMapping("/{id}")
	public IncomeDTO changeBranch (@RequestHeader("Role") String role,@PathVariable("id") Long id, @RequestBody IncomeDTO incomeDto );
	

}
