package com.ftn.isa.projekat.rentACar.rentACarCore.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarReservationDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.service.ICarReservationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/rentacar/reservation")
@Api(value="CarReservation")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {

	@Autowired
	ICarReservationService reservationService;
	
	@GetMapping("/{id}")
	@ApiOperation( value = "Finds one reservation.", notes = "Returns found reservation.", httpMethod="GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message = "OK"),
							 @ApiResponse( code = 404, message = "Not Found")})
	public ResponseEntity<CarReservationDTO> getOneReservationById (@RequestHeader("Role") String role, @PathVariable("id") Long id){

		if(role.equals("USER")) {
			CarReservationDTO reservationDto = reservationService.findOneById(id);
			
			return ( reservationDto.getId()!=null)? new ResponseEntity<CarReservationDTO>(reservationDto,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
	}
	
	@GetMapping("/all")
	@ApiOperation( value = "Returns all reservations", httpMethod = "GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message ="OK"),
							 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<List<CarReservationDTO>> getAllReservations(@RequestHeader("Role") String role){
		if(role.equals("USER")) {
			List<CarReservationDTO> reservations = reservationService.findAll();
			
			return ( !reservations.isEmpty() )? new ResponseEntity<List<CarReservationDTO>>(reservations,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
	}
	
	@PostMapping("/")
	@ApiOperation( value = "Create a reservation.", notes = "Returns the reservation being saved.", httpMethod="POST", produces = "application/json", consumes = "application/json" )
	@ApiResponses( value = {
					@ApiResponse( code = 201 , message = "Created"),
					@ApiResponse( code = 400, message= "Bad request")
	})
	public ResponseEntity<CarReservationDTO> addReservation(@RequestHeader("Role") String role,@RequestBody CarReservationDTO dto){
		if(role.equals("USER")) {
			try {
				CarReservationDTO savedReservation = reservationService.save(dto);
				
				return ( savedReservation!=null )? new ResponseEntity<CarReservationDTO>(savedReservation,HttpStatus.CREATED): new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		    } catch (ObjectOptimisticLockingFailureException e) {
		        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    }
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation( value = "Delete a reservation.", notes = "Returns the reservation being deleted", httpMethod="DELETE")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<CarReservationDTO> deleteReservation(@RequestHeader("Role") String role, @PathVariable("id") Long id){
		if(role.equals("USER")) {
			try {
				CarReservationDTO deletedReservationDTO = reservationService.deleteById(id);
				
				return (deletedReservationDTO.getId() != null ) ? new ResponseEntity<CarReservationDTO>(deletedReservationDTO,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);

		    } catch (ObjectOptimisticLockingFailureException e) {
		        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    }
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/fullDelete/{id}")
	@ApiOperation( value = "Delete a reservation without any conditions.", notes = "Returns the reservation being deleted", httpMethod="DELETE")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 404, message ="Not Found")})
	public ResponseEntity<CarReservationDTO> deleteReservationNoConditions(@RequestHeader("Role") String role, @PathVariable("id") Long id){
		if(role.equals("USER")) {
			try {
				CarReservationDTO deletedReservationDTO = reservationService.deleteByIdNoConditions(id);
				
				return (deletedReservationDTO.getId() != null ) ? new ResponseEntity<CarReservationDTO>(deletedReservationDTO,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);

		    } catch (ObjectOptimisticLockingFailureException e) {
		        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    }
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	
	@PutMapping("/{id}")
	@ApiOperation( value= "Change a reservation", notes = "Returns the reservation being changed", httpMethod="PUT")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 400, message ="Bad Request")})
	public ResponseEntity<CarReservationDTO> changeReservation (@RequestHeader("Role") String role,@PathVariable("id") Long id, @RequestBody CarReservationDTO reservationDTO ){
		if(role.equals("USER")) {
			try {
				CarReservationDTO reservationToEdit = reservationService.changeReservation(id, reservationDTO);
				
			    return ( reservationToEdit.getId() != null )? new ResponseEntity<CarReservationDTO>(reservationToEdit,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		    } catch (ObjectOptimisticLockingFailureException e) {
		        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    }
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	

	

	
	
}
