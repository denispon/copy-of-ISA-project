package com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.controller;

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

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.BranchOfficeDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.service.IBranchOfficeService;

@RestController
@RequestMapping("/api/branchOffice")
public class BranchOfficeController {
	
	@Autowired
	IBranchOfficeService branchOfficeService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<BranchOfficeDTO> getOneBranchOfficeById (@PathVariable("id") Long id){
		
		BranchOfficeDTO branchDto = branchOfficeService.findOneById(id);
		
		return ( !branchDto.getName().isEmpty() )? new ResponseEntity<BranchOfficeDTO>(branchDto,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<BranchOfficeDTO>> getAllBranches(){
		
		List<BranchOfficeDTO> branches = branchOfficeService.findAll();
		
		return (!branches.isEmpty())? new ResponseEntity<List<BranchOfficeDTO>>(branches,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<BranchOfficeDTO> addBranchOffice(@RequestBody BranchOfficeDTO dto){
		
		BranchOfficeDTO savedBranch = branchOfficeService.save(dto);
		
		return (savedBranch!=null)? new ResponseEntity<BranchOfficeDTO>(savedBranch,HttpStatus.CREATED): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<BranchOfficeDTO> deleteBranchOffice(@PathVariable("id") Long id){
		BranchOfficeDTO deletedBranchDTO = branchOfficeService.deleteById(id);
		
		return (deletedBranchDTO!=null) ? new ResponseEntity<BranchOfficeDTO>(deletedBranchDTO,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BranchOfficeDTO> changeBranch (@PathVariable("id") Long id, @RequestBody BranchOfficeDTO branchDto ){
		
		BranchOfficeDTO branchToEdit = branchOfficeService.changeBranchOffice(id, branchDto);
	
	    return (branchToEdit!=null)? new ResponseEntity<BranchOfficeDTO>(branchToEdit,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
