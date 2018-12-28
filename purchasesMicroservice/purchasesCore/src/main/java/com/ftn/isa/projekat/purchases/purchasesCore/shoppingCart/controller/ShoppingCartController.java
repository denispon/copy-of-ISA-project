package com.ftn.isa.projekat.purchases.purchasesCore.shoppingCart.controller;

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

import com.ftn.isa.projekat.purchases.purchasesApi.dto.ShoppingCartDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.shoppingCart.service.IShoppingCartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/purchases/shoppingCart")
@Api(value="shoppingCart")
public class ShoppingCartController {

	@Autowired
	IShoppingCartService cartService;
	
	
	
	
	
	@GetMapping("/{id}")
	@ApiOperation( value = "Finds one reservation from shopping cart.", notes = "Returns found reservation from shopping cart.", httpMethod="GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message = "OK"),
							 @ApiResponse( code = 404, message = "Not Found")})
	public ResponseEntity<ShoppingCartDTO> getOneReservationById (@PathVariable("id") Long id){
		
		ShoppingCartDTO ShoppingCartDTO = cartService.findOneById(id);
		
		return ( ShoppingCartDTO.getId()!=null)? new ResponseEntity<ShoppingCartDTO>(ShoppingCartDTO,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/all")
	@ApiOperation( value = "Returns all reservations from shopping cart", httpMethod = "GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message ="OK"),
							 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<List<ShoppingCartDTO>> getAllReservations(){
		
		List<ShoppingCartDTO> reservations = cartService.findAll();
		
		return ( !reservations.isEmpty() )? new ResponseEntity<List<ShoppingCartDTO>>(reservations,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/")
	@ApiOperation( value = "Create a reservation in shopping cart.", notes = "Returns the reservation being saved in shopping cart.", httpMethod="POST", produces = "application/json", consumes = "application/json" )
	@ApiResponses( value = {
					@ApiResponse( code = 201 , message = "Created"),
					@ApiResponse( code = 400, message= "Bad request")
	})
	public ResponseEntity<ShoppingCartDTO> addReservation(@RequestBody ShoppingCartDTO dto){
		
		ShoppingCartDTO savedReservation = cartService.save(dto);
		
		return ( savedReservation!=null )? new ResponseEntity<ShoppingCartDTO>(savedReservation,HttpStatus.CREATED): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation( value = "Delete a reservation from shopping cart.", notes = "Returns the reservation being deleted from shopping cart", httpMethod="DELETE")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<ShoppingCartDTO> deleteReservation(@PathVariable("id") Long id){
		ShoppingCartDTO deletedShoppingCartDTO = cartService.deleteById(id);
		
		return (deletedShoppingCartDTO.getId() != null ) ? new ResponseEntity<ShoppingCartDTO>(deletedShoppingCartDTO,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	@ApiOperation( value= "Change a reservation from shopping cart", notes = "Returns the reservation being changed from shopping cart", httpMethod="PUT")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 400, message ="Bad Request")})
	public ResponseEntity<ShoppingCartDTO> changeReservation (@PathVariable("id") Long id, @RequestBody ShoppingCartDTO ShoppingCartDTO ){
		
		ShoppingCartDTO reservationToEdit = cartService.changeReservation(id, ShoppingCartDTO);
	
	    return ( reservationToEdit.getId() != null )? new ResponseEntity<ShoppingCartDTO>(reservationToEdit,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
		
}
