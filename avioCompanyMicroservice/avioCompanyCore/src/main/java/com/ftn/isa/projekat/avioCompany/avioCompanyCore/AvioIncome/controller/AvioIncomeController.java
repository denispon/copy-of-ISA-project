package com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioIncomeDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.service.IAvioIncomeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Component
@RestController //oznacava samo da je ovo rest controller
@RequestMapping("/api/aviocompany/income") //mapira http zahtev sa klasom/metodom na serverskoj strani
@Api(value = "income") //sve ove api anotacije su vezane manje vise za dokumentaciju (moje misljenje)
public class AvioIncomeController
{
	@Autowired
	IAvioIncomeService incomeService;
	
	//READ BY ID
	@GetMapping("/{id}") //skracenica za @RequestMapping(value = "/id", method = RequestMethod.GET)
	//inace metoda GetMapping mapira ovo za url sa get zahtevom
	
	@ApiOperation(value = "Finds one income.", notes = "Returns one income.", httpMethod = "GET")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 404, message = "Not Found")
	})
	public ResponseEntity<AvioIncomeDTO> getOneIncomeById(@PathVariable("id") Long id) //ovo PathVariable kupi parametar id iz URL-a i smesta u promenljivu Long id kao parametar funkcije
	{
		AvioIncomeDTO incomeDto = incomeService.findOneById(id);
		
		return (incomeDto.getId()!=null) ? new ResponseEntity<AvioIncomeDTO>(incomeDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//ResponseEntity -> odgovor koji moze da sadrzi vise informacija (npr statusni kod, same podatke (metode anotirane sa @ResponseBody sadrze samo telo (body zaglavlje)), head zaglavlje itd..
	
	//READ ALL
	@GetMapping("/all")
	@ApiOperation(value = "Returns all incomes", httpMethod = "GET")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 404, message = "Not Found")
	})
	public ResponseEntity<List<AvioIncomeDTO>> getAllIncomes()
	{
		List<AvioIncomeDTO> incomes = incomeService.findAll();
		
		return (!incomes.isEmpty()) ? new ResponseEntity<List<AvioIncomeDTO>>(incomes, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//INSERT NEW INCOME
	@PostMapping("/")
	@ApiOperation(value = "Create a income.", notes = "Returns the income that has been saved.", httpMethod = "POST")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Created"),
						   @ApiResponse(code = 400, message = "Bad request")
	})
	public ResponseEntity<AvioIncomeDTO> addIncome(@RequestBody AvioIncomeDTO dto) //responsebody konvertuje json u nesto koliko sam skapirao
	{
		AvioIncomeDTO inc = incomeService.save(dto);
		
		return (inc != null) ? new ResponseEntity<AvioIncomeDTO>(inc, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	//DELETE INCOME (mozda treba da se brise samo ako se obrise ta kompanija?)
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete income.", notes = "Returns the income that has been deleted.", httpMethod = "DELETE")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 404, message = "Not found")
	})
	public ResponseEntity<AvioIncomeDTO> deleteIncome(@PathVariable("id") Long id)
	{
		AvioIncomeDTO deleted = incomeService.deleteById(id);
		
		return (deleted.getId() != null) ? new ResponseEntity<AvioIncomeDTO>(deleted, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//UPDATE (na trenutni prihod dodati novi, ali da admin nema ovu opciju nego da ide automatski - valjda)
	@PutMapping("/{id}")
	@ApiOperation(value = "Chane income.", notes = "Returns the income that has been changed", httpMethod = "PUT")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 400, message = "Bad request")
	})
	public ResponseEntity<AvioIncomeDTO> changeIncome(@PathVariable("id") Long id, @RequestBody AvioIncomeDTO dto) //RequestBody ide samo kod onih funkcija koje kreiraju nesto, novi objekat, valjda mapira taj java objekat na resurs spreman za slanje 
	//na klijentsku stranu (mada realno ovde se samo kreira novi objekat vtf (vidi rest-slajdove - vezbe3)
	//@ResponseBody ide kod get zahteva, @RequestBodu kod post i put
	{
		AvioIncomeDTO editIncome = incomeService.changeIncome(id, dto);
		
		return (editIncome.getId() != null) ? new ResponseEntity<AvioIncomeDTO>(editIncome, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
}
