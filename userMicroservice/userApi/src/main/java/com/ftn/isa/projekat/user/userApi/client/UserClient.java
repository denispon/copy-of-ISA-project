package com.ftn.isa.projekat.user.userApi.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ftn.isa.projekat.user.userApi.dto.UserDTO;
import com.ftn.isa.projekat.user.userApi.dto.UserForRegistrationDTO;


@FeignClient(name="userClient", url="http://localhost:8096/api/user/user")
public interface UserClient {

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getOneUserById (@PathVariable("id") Long id);
	
	@GetMapping("/all")	
	public ResponseEntity<List<UserDTO>> getAllUsers();
	
	@PostMapping("/")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO dto);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") Long id);
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> changeUser (@PathVariable("id") Long id, @RequestBody UserDTO userDto );
	
	@GetMapping("/friends/{id}")
	public ResponseEntity<List<UserDTO>> getAllFriends(@PathVariable("id") Long id);
	
	
	@PostMapping("/register")
	public ResponseEntity<UserForRegistrationDTO> registerUser(@RequestBody UserForRegistrationDTO dto);
	
	@GetMapping("/activate/{id}")
	public ResponseEntity<UserDTO> activateUser(@PathVariable("id") Long id);
	
	
	@GetMapping("/role/{id}")
	public ResponseEntity<List<UserDTO>> getAllUsersByRole(@PathVariable("id") Long id);
	
}
