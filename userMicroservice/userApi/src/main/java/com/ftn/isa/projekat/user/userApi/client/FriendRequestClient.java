package com.ftn.isa.projekat.user.userApi.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ftn.isa.projekat.user.userApi.dto.FriendRequestDTO;


@FeignClient(name="friendRequestClient", url = "http://localhost:8096/api/user/friendRequest")
public interface FriendRequestClient {

	@GetMapping("/{id}")
	public ResponseEntity<FriendRequestDTO> getOneFriendRequestById (@PathVariable("id") Long id);
	
	@GetMapping("/all")
	public ResponseEntity<List<FriendRequestDTO>> getAllRequests();
	
	@PostMapping("/")
	public ResponseEntity<FriendRequestDTO> addFriendRequest(@RequestBody FriendRequestDTO dto);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<FriendRequestDTO> deleteFriendRequest(@PathVariable("id") Long id);
	
	@PutMapping("/{id}")
	public ResponseEntity<FriendRequestDTO> changeRequest (@PathVariable("id") Long id, @RequestBody FriendRequestDTO requestDto );
	
	@PutMapping("/acceptRequest/{id}")
	public ResponseEntity<FriendRequestDTO> acceptRequest (@PathVariable("id") Long id);
}
