package com.ftn.isa.projekat.user.userCore.friendRequest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.user.userApi.dto.FriendRequestDTO;
import com.ftn.isa.projekat.user.userCore.converter.DTOFriendRequestConverter;
import com.ftn.isa.projekat.user.userCore.friendRequest.model.FriendRequest;
import com.ftn.isa.projekat.user.userCore.friendRequest.repository.FriendRequestRepository;

@Component
public class FriendRequestServiceImpl implements IFriendRequestService {

	@Autowired
	FriendRequestRepository requestRepository;
	
	@Autowired
	DTOFriendRequestConverter requestConverter;
	
	
	@Override
	public FriendRequestDTO findOneById(Long id) {
		
		Optional <FriendRequest> friendRequest = requestRepository.findById(id);
		
		
		if (friendRequest.isPresent()) {
			
			return requestConverter.convertToDTO(friendRequest.get());
		
		}
		else {
			
			return new FriendRequestDTO();
			
		}
		
	}

	@Override
	public List<FriendRequestDTO> findAll() {

		Optional< List<FriendRequest> > list = Optional.of(requestRepository.findAll());
		ArrayList< FriendRequestDTO > friendRequestsDTO = new ArrayList< FriendRequestDTO >();
		
		if ( list.isPresent() ) {
			
			for ( FriendRequest request : list.get()) {
				
				friendRequestsDTO.add(requestConverter.convertToDTO(request));
				
			}
			
			return friendRequestsDTO;
			
		}
		
		return Collections.emptyList();
		
	}

	@Override
	public FriendRequestDTO save(FriendRequestDTO friendRequestToSave) {
		
		requestRepository.save(requestConverter.convertFromDTO(friendRequestToSave));
		
		return friendRequestToSave;
	}

	@Override
	public FriendRequestDTO deleteById(Long id) {
		
		Optional<FriendRequest> friendRequestToDelete = requestRepository.findById(id);
		
		if( friendRequestToDelete.isPresent() ) {
		
			requestRepository.deleteById(id);
			
			return requestConverter.convertToDTO(friendRequestToDelete.get());
		
		}
		
		return new FriendRequestDTO();
		
		
	}

	@Override
	public FriendRequestDTO changeFriendRequest(Long id, FriendRequestDTO friendRequest) {
		
		Optional<FriendRequest> requestForChange = requestRepository.findById(id);
		
		if(requestForChange.isPresent() && friendRequest !=null) {
			
			requestForChange.get().setInvitedUser(friendRequest.getInvitedUser());
			requestForChange.get().setSourceUser(friendRequest.getSourceUser());
			requestForChange.get().setStatus(friendRequest.getStatus());
			
			requestRepository.save(requestForChange.get());
			
			friendRequest.setId(requestForChange.get().getId());
			
			return friendRequest;
			
			
		}
		
		return new FriendRequestDTO();
		
	}

}
