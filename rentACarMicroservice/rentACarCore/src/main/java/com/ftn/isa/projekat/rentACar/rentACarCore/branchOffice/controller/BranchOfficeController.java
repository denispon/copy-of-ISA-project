package com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.BranchOfficeDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.service.IBranchOfficeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/rentacar/branchOffice")
@Api(value = "branchOffice")
@CrossOrigin(origins = "http://localhost:3000")
public class BranchOfficeController {
	
	@Autowired
	IBranchOfficeService branchOfficeService;
	
	
	@GetMapping("/{id}")
	@ApiOperation( value = "Finds one branch office.", notes = "Returns found branch office.", httpMethod="GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message = "OK"),
							 @ApiResponse( code = 404, message = "Not Found")})
	public ResponseEntity<BranchOfficeDTO> getOneBranchOfficeById (@PathVariable("id") Long id){
		
		BranchOfficeDTO branchDto = branchOfficeService.findOneById(id);
		
		return ( branchDto.getId()!=null)? new ResponseEntity<BranchOfficeDTO>(branchDto,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/all")
	@ApiOperation( value = "Returns all branch offices", httpMethod = "GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message ="OK"),
							 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<List<BranchOfficeDTO>> getAllBranches(){
		
		List<BranchOfficeDTO> branches = branchOfficeService.findAll();
		
		return ( !branches.isEmpty() )? new ResponseEntity<List<BranchOfficeDTO>>(branches,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/")
	@ApiOperation( value = "Create a branch office.", notes = "Returns the branch office being saved.", httpMethod="POST", produces = "application/json", consumes = "application/json" )
	@ApiResponses( value = {
					@ApiResponse( code = 201 , message = "Created"),
					@ApiResponse( code = 400, message= "Bad request")
	})
	public ResponseEntity<BranchOfficeDTO> addBranchOffice(@RequestHeader("Role") String role,@RequestBody BranchOfficeDTO dto){
		if(role.equals("CARADMIN")) {
		BranchOfficeDTO savedBranch = branchOfficeService.save(dto);
		
		return ( savedBranch!=null )? new ResponseEntity<BranchOfficeDTO>(savedBranch,HttpStatus.CREATED): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation( value = "Delete a branch office.", notes = "Returns the branch office being deleted", httpMethod="DELETE")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<BranchOfficeDTO> deleteBranchOffice(@RequestHeader("Role") String role,@PathVariable("id") Long id){
		if(role.equals("CARADMIN")) {
			BranchOfficeDTO deletedBranchDTO = branchOfficeService.deleteById(id);
			
			return (deletedBranchDTO.getId() != null ) ? new ResponseEntity<BranchOfficeDTO>(deletedBranchDTO,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping("/{id}")
	@ApiOperation( value= "Change a branch office", notes = "Returns the branch office being changed", httpMethod="PUT")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 400, message ="Bad Request")})
	public ResponseEntity<BranchOfficeDTO> changeBranch (@RequestHeader("Role") String role, @PathVariable("id") Long id, @RequestBody BranchOfficeDTO branchDto ){
		if(role.equals("CARADMIN")) {
			BranchOfficeDTO branchToEdit = branchOfficeService.changeBranchOffice(id, branchDto);
			
		    return ( branchToEdit.getId() != null )? new ResponseEntity<BranchOfficeDTO>(branchToEdit,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/getAllByRentService/{id}")
	@ApiOperation( value = "Returns all branch offices of one rent a car service", httpMethod = "GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message ="OK"),
							 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<List<BranchOfficeDTO>> getAllBranchesByRentService(@PathVariable("id") Long rentId){
		
		List<BranchOfficeDTO> branches = branchOfficeService.findAllByRentServiceId(rentId);
		
		return ( !branches.isEmpty() )? new ResponseEntity<List<BranchOfficeDTO>>(branches,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

}
