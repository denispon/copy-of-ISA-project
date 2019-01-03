package com.ftn.isa.projekat.hotel.hotelCore.PrihodiHotela.controller;

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
import com.ftn.isa.projekat.hotel.hotelApi.dto.PrihodiHotelaDTO;
import com.ftn.isa.projekat.hotel.hotelCore.PrihodiHotela.service.IPrihodiHotelaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/hotel/prihodi")
@Api(value = "prihodi")
public class PrihodiHotelaController {
	
	@Autowired
	IPrihodiHotelaService prihodiHotelaService;
	
	@GetMapping("/{id}")
	@ApiOperation( value = "", notes = "", httpMethod="GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message = "OK"),
							 @ApiResponse( code = 404, message = "Not Found")})
	public ResponseEntity<PrihodiHotelaDTO> getPrihod(@PathVariable("id") Long id){
		
		PrihodiHotelaDTO dto = prihodiHotelaService.findOneById(id);
		return (dto.getId()!=null) ? new ResponseEntity<PrihodiHotelaDTO>(dto, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/all")
	@ApiOperation( value = "", httpMethod = "GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message ="OK"),
							 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<List<PrihodiHotelaDTO>> getAllPrihode(){
		
		List<PrihodiHotelaDTO> lista = prihodiHotelaService.findAll();
		return(!lista.isEmpty()) ? new ResponseEntity<List<PrihodiHotelaDTO>>(lista, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/")
	@ApiOperation( value = "", notes = "", httpMethod="POST", produces = "application/json", consumes = "application/json" )
	@ApiResponses( value = {
					@ApiResponse( code = 201 , message = "Created"),
					@ApiResponse( code = 400, message= "Bad request")})
	public ResponseEntity<PrihodiHotelaDTO> addCenovnik(@RequestBody PrihodiHotelaDTO dto){
		PrihodiHotelaDTO zaSnimanje = prihodiHotelaService.save(dto);
		return(zaSnimanje!=null) ? new ResponseEntity<PrihodiHotelaDTO>(zaSnimanje, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation( value = "", notes = "", httpMethod="DELETE")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<PrihodiHotelaDTO> deleteCenovnik(@PathVariable("id") Long id){
		
		PrihodiHotelaDTO zaBrisanje = prihodiHotelaService.deleteById(id);
		return (zaBrisanje.getId()!=null) ? new ResponseEntity<PrihodiHotelaDTO>(zaBrisanje, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/{id}")
	@ApiOperation( value= "", notes = "", httpMethod="PUT")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 400, message ="Bad Request")})
	public ResponseEntity<PrihodiHotelaDTO> changeCenovnik(@PathVariable("id") Long id, @RequestBody PrihodiHotelaDTO dto ){
		PrihodiHotelaDTO zaIzmenu = prihodiHotelaService.change(id, dto);
		return (zaIzmenu.getId()!=null) ? new ResponseEntity<PrihodiHotelaDTO>(zaIzmenu, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
