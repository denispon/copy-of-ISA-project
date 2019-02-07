package com.ftn.isa.projekat.user.userApi.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ftn.isa.projekat.user.userApi.dto.UserDTO;
import com.ftn.isa.projekat.user.userApi.dto.UserForRegistrationDTO;


@FeignClient(name="userClient", url="http://localhost:8096/api/user/user")
public interface UserClient {

	@GetMapping("/{id}")
	public UserDTO getOneUserById (@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	@GetMapping("/all")	
	public List<UserDTO> getAllUsers(@RequestHeader("Role") String role);
	
	@PostMapping("/")
	public UserDTO addUser(@RequestHeader("Role") String role,@RequestBody UserDTO dto);
	
	@DeleteMapping("/{id}")
	public UserDTO deleteUser(@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	@PutMapping("/{id}")
	public UserDTO changeUser (@RequestHeader("Role") String role,@PathVariable("id") Long id, @RequestBody UserDTO userDto );
	
	@GetMapping("/friends/{id}")
	public List<UserDTO> getAllFriends(@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	
	@PostMapping("/register")
	public UserForRegistrationDTO registerUser(@RequestBody UserForRegistrationDTO dto);
	
	@GetMapping("/activate/{id}")
	public UserDTO activateUser(@PathVariable("id") Long id);
	
	
	@GetMapping("/role/{id}")
	public List<UserDTO> getAllUsersByRole(@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
}
