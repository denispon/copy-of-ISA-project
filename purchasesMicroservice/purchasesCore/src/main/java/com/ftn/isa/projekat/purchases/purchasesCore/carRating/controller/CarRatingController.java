package com.ftn.isa.projekat.purchases.purchasesCore.carRating.controller;

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

import com.ftn.isa.projekat.purchases.purchasesApi.dto.CarRatingDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.carRating.service.ICarRatingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/purchases/carRating")
@Api(value="carRating")
public class CarRatingController {

	@Autowired
	ICarRatingService carRatingService;
	
	
	@GetMapping("/{id}")
	@ApiOperation( value = "Finds one car rating.", notes = "Returns found car rating.", httpMethod="GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message = "OK"),
							 @ApiResponse( code = 404, message = "Not Found")})
	public ResponseEntity<CarRatingDTO> getOneBranchOfficeById (@PathVariable("id") Long id){
		
		CarRatingDTO carRatingDto = carRatingService.findOneById(id);
		
		return ( carRatingDto.getId()!=null)? new ResponseEntity<CarRatingDTO>(carRatingDto,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/all")
	@ApiOperation( value = "Returns all car ratings", httpMethod = "GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message ="OK"),
							 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<List<CarRatingDTO>> getAllCarRating(){
		
		List<CarRatingDTO> carRatings = carRatingService.findAll();
		
		return ( !carRatings.isEmpty() )? new ResponseEntity<List<CarRatingDTO>>(carRatings,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/")
	@ApiOperation( value = "Create a car rating.", notes = "Returns the car rating being saved.", httpMethod="POST", produces = "application/json", consumes = "application/json" )
	@ApiResponses( value = {
					@ApiResponse( code = 201 , message = "Created"),
					@ApiResponse( code = 400, message= "Bad request")
	})
	public ResponseEntity<CarRatingDTO> addCarRating(@RequestBody CarRatingDTO dto){
		
		CarRatingDTO savedCarRating = carRatingService.save(dto);
		
		return ( savedCarRating!=null )? new ResponseEntity<CarRatingDTO>(savedCarRating,HttpStatus.CREATED): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation( value = "Delete a car rating.", notes = "Returns the car rating being deleted", httpMethod="DELETE")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<CarRatingDTO> deleteCarRating(@PathVariable("id") Long id){
		CarRatingDTO deletedCarRatingDTO = carRatingService.deleteById(id);
		
		return (deletedCarRatingDTO.getId() != null ) ? new ResponseEntity<CarRatingDTO>(deletedCarRatingDTO,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	@ApiOperation( value= "Change a car rating", notes = "Returns the car rating being changed", httpMethod="PUT")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 400, message ="Bad Request")})
	public ResponseEntity<CarRatingDTO> changeCarRating (@PathVariable("id") Long id, @RequestBody CarRatingDTO carRatingDto ){
		
		CarRatingDTO carRatingToEdit = carRatingService.changeCarRating(id, carRatingDto);
	
	    return ( carRatingToEdit.getId() != null )? new ResponseEntity<CarRatingDTO>(carRatingToEdit,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}	
	
	
	@PutMapping("/rateCar/{userId}/{carId}/{rating}")
	public ResponseEntity<CarRatingDTO> rateCar (@PathVariable("userId") Long userId,@PathVariable("carId") Long carId, @PathVariable("rating") int rating){
		
		CarRatingDTO ratedCar = carRatingService.rateCarReservation(userId, carId, rating);
		
	    return ( ratedCar.getId() != null )? new ResponseEntity<CarRatingDTO>(ratedCar,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
}
