package com.ftn.isa.projekat.avioCompany.avioCompanyCore.PlaceInPlane.controller;

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

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.PlaceInPlaneDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.PlaceInPlane.service.IPlaceInPlaneService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/aviocompany/plane")
@Api(value = "plane")
public class PlaceInPlaneController
{
	@Autowired
	IPlaceInPlaneService service;
	
	//READ ONE
	@GetMapping("/{id}")
	@ApiOperation(value = "Finds one place in plane.", notes = "Returns founded place.", httpMethod = "GET")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 404, message = "NOT_FOUND")
	})
	public ResponseEntity<PlaceInPlaneDTO> getOnePlaceInPlaneById(@PathVariable("id") Long id)
	{
		PlaceInPlaneDTO dto = service.findOneById(id);
		
		return (dto.getId() != null) ? new ResponseEntity<PlaceInPlaneDTO>(dto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//READ ALL
	@GetMapping("/all")
	@ApiOperation(value = "Finds all places.", notes = "Returns all places in plane.", httpMethod = "GET")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 404, message = "NOT_FOUND")
	})
	public ResponseEntity<List<PlaceInPlaneDTO>> getAllPlacesInPlane()
	{
		List<PlaceInPlaneDTO> list = service.findAll();
		
		return (!list.isEmpty()) ? new ResponseEntity<List<PlaceInPlaneDTO>>(list, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	//CREATE
	@PostMapping("/")
	@ApiOperation(value = "Create new place.", notes = "Returns created place in plane.",  produces = "application/json", consumes = "application/json" )
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 400, message = "BAD_REQUEST")
	})
	public ResponseEntity<PlaceInPlaneDTO> addPlace(@RequestBody PlaceInPlaneDTO dto)
	{
		PlaceInPlaneDTO place = service.save(dto);
		
		return (place != null) ? new ResponseEntity<PlaceInPlaneDTO>(place, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete place in plane.", notes = "Returns deleted place.", httpMethod = "DELETE")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 404, message = "NOT_FOUND")
	})
	public ResponseEntity<PlaceInPlaneDTO> deleteById(@PathVariable("id") Long id)
	{
		PlaceInPlaneDTO dto = service.deleteById(id);
		
		return (dto.getId() != null) ? new ResponseEntity<PlaceInPlaneDTO>(dto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//UPDATE
	@PutMapping("/{id}")
	@ApiOperation(value = "Update place in plane.", notes = "Returns updated place.", httpMethod = "PUT")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 400, message = "BAD_REQUEST")
	})
	public ResponseEntity<PlaceInPlaneDTO> changePlace(@PathVariable("id") Long id, @RequestBody PlaceInPlaneDTO placeToUpdate)
	{
		PlaceInPlaneDTO dto = service.changePlace(id, placeToUpdate);
		
		return (dto.getId() != null) ? new ResponseEntity<PlaceInPlaneDTO>(dto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
