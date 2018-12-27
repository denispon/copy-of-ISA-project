package com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.controller;

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

import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelskaSobaDTO;
import com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.service.IHotelskaSobaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/hotel/hotelskaSoba")
@Api(value = "hotelskaSoba")
public class HotelskaSobaController {
	
	@Autowired
	IHotelskaSobaService hotelskaSobaService;
	
	@GetMapping("/{id}")
	@ApiOperation( value = "", notes = "", httpMethod="GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message = "OK"),
							 @ApiResponse( code = 404, message = "Not Found")})
	public ResponseEntity<HotelskaSobaDTO> getHotelskaSoba(@PathVariable("id") Long id){
		
		HotelskaSobaDTO sobaDTO = hotelskaSobaService.findOneById(id);
		return (sobaDTO.getId()!=null) ? new ResponseEntity<HotelskaSobaDTO>(sobaDTO, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/all")
	@ApiOperation( value = "", httpMethod = "GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message ="OK"),
							 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<List<HotelskaSobaDTO>> getAllHotelRooms(){
		
		List<HotelskaSobaDTO> rooms = hotelskaSobaService.findAll();
		return(!rooms.isEmpty()) ? new ResponseEntity<List<HotelskaSobaDTO>>(rooms, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/")
	@ApiOperation( value = "", notes = "", httpMethod="POST", produces = "application/json", consumes = "application/json" )
	@ApiResponses( value = {
					@ApiResponse( code = 201 , message = "Created"),
					@ApiResponse( code = 400, message= "Bad request")})
	public ResponseEntity<HotelskaSobaDTO> addHotelRoom(@RequestBody HotelskaSobaDTO sobaDTO){
		HotelskaSobaDTO sobaZaSnimanje = hotelskaSobaService.save(sobaDTO);
		return(sobaZaSnimanje!=null) ? new ResponseEntity<HotelskaSobaDTO>(sobaZaSnimanje, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation( value = "", notes = "", httpMethod="DELETE")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<HotelskaSobaDTO> deleteHotelRoom(@PathVariable("id") Long id){
		
		HotelskaSobaDTO sobaZaBrisanje = hotelskaSobaService.deleteById(id);
		return (sobaZaBrisanje.getId()!=null) ? new ResponseEntity<HotelskaSobaDTO>(sobaZaBrisanje, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/{id}")
	@ApiOperation( value= "", notes = "", httpMethod="PUT")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 400, message ="Bad Request")})
	public ResponseEntity<HotelskaSobaDTO> changeHotelRoom(@PathVariable("id") Long id, @RequestBody HotelskaSobaDTO sobaDTO ){
		HotelskaSobaDTO sobaZaIzmenu = hotelskaSobaService.change(id, sobaDTO);
		return (sobaZaIzmenu.getId()!=null) ? new ResponseEntity<HotelskaSobaDTO>(sobaZaIzmenu, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
