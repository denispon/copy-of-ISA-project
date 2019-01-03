package com.ftn.isa.projekat.hotel.hotelCore.RezervacijeSobe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.isa.projekat.hotel.hotelApi.dto.CenovnikUslugaDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.RezervacijeSobeDTO;
import com.ftn.isa.projekat.hotel.hotelCore.RezervacijeSobe.service.IRezervacijeSobeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/hotel/rezervacije")
@Api(value = "rezervacije")
public class RezervacijeSobeController {
	
	@Autowired
	IRezervacijeSobeService rezervacijeSobeService;
	
	@GetMapping("/{id}")
	@ApiOperation( value = "", notes = "", httpMethod="GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message = "OK"),
							 @ApiResponse( code = 404, message = "Not Found")})
	public ResponseEntity<RezervacijeSobeDTO> getRezervaciju(@PathVariable("id") Long id){
		
		RezervacijeSobeDTO dto = rezervacijeSobeService.findOneById(id);
		return (dto.getId()!=null) ? new ResponseEntity<RezervacijeSobeDTO>(dto, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/all")
	@ApiOperation( value = "", httpMethod = "GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message ="OK"),
							 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<List<RezervacijeSobeDTO>> getAllRezervacije(){
		
		List<RezervacijeSobeDTO> lista = rezervacijeSobeService.findAll();
		return(!lista.isEmpty()) ? new ResponseEntity<List<RezervacijeSobeDTO>>(lista, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/")
	@ApiOperation( value = "", notes = "", httpMethod="POST", produces = "application/json", consumes = "application/json" )
	@ApiResponses( value = {
					@ApiResponse( code = 201 , message = "Created"),
					@ApiResponse( code = 400, message= "Bad request")})
	public ResponseEntity<RezervacijeSobeDTO> addRezervaciju(@RequestBody RezervacijeSobeDTO dto){
		RezervacijeSobeDTO zaSnimanje = rezervacijeSobeService.save(dto);
		return(zaSnimanje!=null) ? new ResponseEntity<RezervacijeSobeDTO>(zaSnimanje, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation( value = "", notes = "", httpMethod="DELETE")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<RezervacijeSobeDTO> deleteRezervaciju(@PathVariable("id") Long id){
		
		RezervacijeSobeDTO zaBrisanje = rezervacijeSobeService.deleteById(id);
		return (zaBrisanje.getId()!=null) ? new ResponseEntity<RezervacijeSobeDTO>(zaBrisanje, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/{id}")
	@ApiOperation( value= "", notes = "", httpMethod="PUT")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 400, message ="Bad Request")})
	public ResponseEntity<RezervacijeSobeDTO> changeCenovnik(@PathVariable("id") Long id, @RequestBody RezervacijeSobeDTO dto ){
		RezervacijeSobeDTO zaIzmenu = rezervacijeSobeService.change(id, dto);
		return (zaIzmenu.getId()!=null) ? new ResponseEntity<RezervacijeSobeDTO>(zaIzmenu, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}