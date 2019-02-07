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

import com.ftn.isa.projekat.user.userApi.dto.FriendRequestDTO;


@FeignClient(name="friendRequestClient", url = "http://localhost:8096/api/user/friendRequest")
public interface FriendRequestClient {

	@GetMapping("/{id}")
	public FriendRequestDTO getOneFriendRequestById (@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	@GetMapping("/all")
	public List<FriendRequestDTO> getAllRequests(@RequestHeader("Role") String role);
	
	@PostMapping("/")
	public FriendRequestDTO addFriendRequest(@RequestHeader("Role") String role,@RequestBody FriendRequestDTO dto);
	
	@DeleteMapping("/{id}")
	public FriendRequestDTO deleteFriendRequest(@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	@PutMapping("/{id}")
	public FriendRequestDTO changeRequest (@RequestHeader("Role") String role,@PathVariable("id") Long id, @RequestBody FriendRequestDTO requestDto );
	
	@PutMapping("/acceptRequest/{id}")
	public FriendRequestDTO acceptRequest (@RequestHeader("Role") String role,@PathVariable("id") Long id);
}
