package com.ftn.isa.projekat.avioCompany.avioCompanyCore.TransferLocation.controller;

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

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.TransferLocationDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.TransferLocation.service.ITransferLocationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/aviocompany/transferlocation")
@Api("transferlocation")
public class TransferLocationController 
{
	@Autowired
	ITransferLocationService service;
	
	@GetMapping("/{id}")
	@ApiOperation( value = "Finds one transfer location.", notes = "Returns found transfer location.", httpMethod="GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message = "OK"),
							 @ApiResponse( code = 404, message = "Not Found")})
	public ResponseEntity<TransferLocationDTO> getOneLocationById (@PathVariable("id") Long id){
		
		TransferLocationDTO transfer = service.findOneById(id);
		
		return ( transfer.getId()!=null)? new ResponseEntity<TransferLocationDTO>(transfer,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/all")
	@ApiOperation( value = "Returns all transfer location.", httpMethod = "GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message ="OK"),
							 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<List<TransferLocationDTO>> getAllLocations(){
		
		List<TransferLocationDTO> dto = service.findAll();
		
		return ( !dto.isEmpty() )? new ResponseEntity<List<TransferLocationDTO>>(dto,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/")
	@ApiOperation( value = "Create a location.", notes = "Returns the location being saved.", httpMethod="POST", produces = "application/json", consumes = "application/json" )
	@ApiResponses( value = {
					@ApiResponse( code = 201 , message = "Created"),
					@ApiResponse( code = 400, message= "Bad request")
	})
	public ResponseEntity<TransferLocationDTO> addLocation(@RequestBody TransferLocationDTO dto){
		
		TransferLocationDTO transfer = service.save(dto);
		
		return ( transfer!=null )? new ResponseEntity<TransferLocationDTO>(transfer,HttpStatus.CREATED): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation( value = "Delete a location.", notes = "Returns the location being deleted", httpMethod="DELETE")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<TransferLocationDTO> deleteLocation(@PathVariable("id") Long id)
	{
		TransferLocationDTO dto = service.deleteById(id);
		
		return (dto.getId() != null ) ? new ResponseEntity<TransferLocationDTO>(dto,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	@ApiOperation( value= "Change a location", notes = "Returns the location being changed", httpMethod="PUT")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 400, message ="Bad Request")})
	public ResponseEntity<TransferLocationDTO> changeLocation(@PathVariable("id") Long id, @RequestBody TransferLocationDTO TransferLocationDTO ){
		
		TransferLocationDTO dto = service.changeLocation(id, TransferLocationDTO);
	
	    return ( dto.getId() != null )? new ResponseEntity<TransferLocationDTO>(dto,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	

}
