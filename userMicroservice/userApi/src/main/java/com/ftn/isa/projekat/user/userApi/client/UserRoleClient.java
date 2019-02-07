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

import com.ftn.isa.projekat.user.userApi.dto.UserRoleDTO;


@FeignClient(name="userRoleClient" , url ="http://localhost:8096/api/user/userRole")
public interface UserRoleClient {

	@GetMapping("/{id}")
	public UserRoleDTO getOneUserRoleById (@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	@GetMapping("/all")
	public List<UserRoleDTO> getAllUserRoles(@RequestHeader("Role") String role);
	
	@PostMapping("/")
	public UserRoleDTO addUserRole(@RequestHeader("Role") String role,@RequestBody UserRoleDTO dto);
	
	@DeleteMapping("/{id}")
	public UserRoleDTO deleteUserRole(@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	@PutMapping("/{id}")
	public UserRoleDTO changeUserRole (@RequestHeader("Role") String role,@PathVariable("id") Long id, @RequestBody UserRoleDTO roleDto );


}
