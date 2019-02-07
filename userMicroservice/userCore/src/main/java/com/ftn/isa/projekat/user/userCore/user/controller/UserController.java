package com.ftn.isa.projekat.user.userCore.user.controller;

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

import com.ftn.isa.projekat.user.userApi.dto.UserCredentialsDTO;
import com.ftn.isa.projekat.user.userApi.dto.UserDTO;
import com.ftn.isa.projekat.user.userApi.dto.UserForRegistrationDTO;
import com.ftn.isa.projekat.user.userCore.user.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/user/user")
@Api(value="user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private IUserService userService;
	

	
	@GetMapping("/{id}")
	@ApiOperation( value = "Finds one user.", notes = "Returns found user.", httpMethod="GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message = "OK"),
							 @ApiResponse( code = 404, message = "Not Found")})
	public ResponseEntity<UserDTO> getOneUserById (@RequestHeader("Role") String role,@PathVariable("id") Long id){
		if(role.equals("ADMIN") || role.equals("USER") || role.equals("CARADMIN") || role.equals("HOTELADMIN")) {
			UserDTO userDto = userService.findOneById(id);
			
			return ( userDto.getId()!=null)? new ResponseEntity<UserDTO>(userDto,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
	}
	
	@GetMapping("/all")
	@ApiOperation( value = "Returns all users", httpMethod = "GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message ="OK"),
							 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<List<UserDTO>> getAllUsers(@RequestHeader("Role") String role){
		if(role.equals("ADMIN")) {
			List<UserDTO> users = userService.findAll();
			
			return ( !users.isEmpty() )? new ResponseEntity<List<UserDTO>>(users,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
	}
	
	@PostMapping("/")
	@ApiOperation( value = "Create an user.", notes = "Returns the user being saved.", httpMethod="POST", produces = "application/json", consumes = "application/json" )
	@ApiResponses( value = {
					@ApiResponse( code = 201 , message = "Created"),
					@ApiResponse( code = 400, message= "Bad request")
	})
	public ResponseEntity<UserDTO> addUser(@RequestHeader("Role") String role, @RequestBody UserDTO dto){
		if(role.equals("ADMIN")) {
			UserDTO savedUser = userService.save(dto);
			
			return ( savedUser!=null )? new ResponseEntity<UserDTO>(savedUser,HttpStatus.CREATED): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation( value = "Delete an user.", notes = "Returns the user being deleted", httpMethod="DELETE")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<UserDTO> deleteUser(@RequestHeader("Role") String role, @PathVariable("id") Long id){
		
		if(role.equals("ADMIN")) {
			UserDTO deletedUserDTO = userService.deleteById(id);
			
			return (deletedUserDTO.getId() != null ) ? new ResponseEntity<UserDTO>(deletedUserDTO,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
	}
	
	@PutMapping("/{id}")
	@ApiOperation( value= "Change an user", notes = "Returns the user being changed", httpMethod="PUT")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 400, message ="Bad Request")})
	public ResponseEntity<UserDTO> changeUser (@RequestHeader("Role") String role, @PathVariable("id") Long id, @RequestBody UserDTO userDto ){
		if(role.equals("ADMIN") || role.equals("USER")) {
			UserDTO userToEdit = userService.changeUser(id, userDto);
			
		    return ( userToEdit.getId() != null )? new ResponseEntity<UserDTO>(userToEdit,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/friends/{id}")
	@ApiOperation( value = "Returns all user friends.", notes = "As parametar this function gets user id", httpMethod = "GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message ="OK"),
							 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<List<UserDTO>> getAllFriends(@RequestHeader("Role") String role, @PathVariable("id") Long id){
		if(role.equals("USER")) {
			List<UserDTO> friends = userService.getallFriends(id);
			
			return ( !friends.isEmpty() )? new ResponseEntity<List<UserDTO>>(friends,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);		
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
	}
	
	@GetMapping("/friendRequest/{id}")
	@ApiOperation( value = "Returns all user from friend requests.", notes = "As parametar this function gets user id", httpMethod = "GET")
	@ApiResponses( value = { @ApiResponse( code = 200, message ="OK"),
							 @ApiResponse( code = 404, message ="Not Found")})	
	public ResponseEntity<List<UserDTO>> getAllFriendRequests(@RequestHeader("Role") String role, @PathVariable("id") Long id){
		if(role.equals("USER")) {
			List<UserDTO> friends = userService.getAllFriendRequests(id);
			
			return ( !friends.isEmpty() )? new ResponseEntity<List<UserDTO>>(friends,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);		
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
	}
	
	
	@PostMapping("/register")
	@ApiOperation( value = "Create an user from registration.", notes = "Returns the user being saved.", httpMethod="POST", produces = "application/json", consumes = "application/json" )
	@ApiResponses( value = {
					@ApiResponse( code = 201 , message = "Created"),
					@ApiResponse( code = 400, message= "Bad request")
	})
	public ResponseEntity<UserForRegistrationDTO> registerUser(@RequestBody UserForRegistrationDTO dto){
		
		UserForRegistrationDTO savedUser = userService.registerUser(dto);
		
		return ( savedUser.getEmail() !=null )? new ResponseEntity<UserForRegistrationDTO>(savedUser,HttpStatus.CREATED): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	} 
	
	@GetMapping("/activate/{id}")
	@ApiOperation( value = "Activate user.", notes = "Returns activated user.", httpMethod="POST", produces = "application/json", consumes = "application/json" )
	@ApiResponses( value = {
					@ApiResponse( code = 201 , message = "Created"),
					@ApiResponse( code = 400, message= "Bad request")
	})
	public ResponseEntity<UserDTO> activateUser(@PathVariable("id") Long id){
		
		UserDTO activatedUser = userService.activateUser(id);
		
		return ( activatedUser!=null )? new ResponseEntity<UserDTO>(activatedUser,HttpStatus.CREATED): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	
	}
	
	
	@GetMapping("/role/{id}")
	@ApiOperation( value = "Get all users with role.", notes = "Returns users with some role.", httpMethod="POST", produces = "application/json", consumes = "application/json" )
	@ApiResponses( value = {
					@ApiResponse( code = 201 , message = "Created"),
					@ApiResponse( code = 400, message= "Bad request")
	})
	public ResponseEntity<List<UserDTO>> getAllUsersByRole(@RequestHeader("Role") String role, @PathVariable("id") Long id){
		if(role.equals("ADMIN")) {
			List<UserDTO> users = userService.findUsersByRole(id);

			return ( !users.isEmpty() )? new ResponseEntity<List<UserDTO>>(users,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);		
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
	}
	
	@PutMapping("/{id}/{idRole}")
	@ApiOperation( value= "Change an user", notes = "Returns the user being changed", httpMethod="PUT")
	@ApiResponses( value = { 
			 @ApiResponse( code = 200, message ="OK"),
			 @ApiResponse( code = 400, message ="Bad Request")})
	public ResponseEntity<UserDTO> changeRoleOfUser(@RequestHeader("Role") String role, @PathVariable("id") Long userId, @PathVariable("idRole") Long roleId){
		if(role.equals("ADMIN")) {
			UserDTO user = userService.changeRoleOfUser(userId,roleId);
			
			
		    return ( user.getId() != null )? new ResponseEntity<UserDTO>(user,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> loginUser(@RequestBody UserCredentialsDTO userCredentials){
		
		UserDTO user = userService.loginUser(userCredentials);
			
	    return ( user.getId() != null )? new ResponseEntity<UserDTO>(user,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
