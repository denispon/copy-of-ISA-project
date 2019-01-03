package com.ftn.isa.projekat.user.userCore.user.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.user.userApi.dto.UserDTO;
import com.ftn.isa.projekat.user.userCore.converter.DTOUserConverter;
import com.ftn.isa.projekat.user.userCore.converter.DTOUserRoleConverter;
import com.ftn.isa.projekat.user.userCore.user.model.User;
import com.ftn.isa.projekat.user.userCore.user.repository.UserRepository;
import com.ftn.isa.projekat.user.userCore.userRole.model.UserRole;
import com.ftn.isa.projekat.user.userCore.userRole.repository.UserRoleRepository;

@Component
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserRoleRepository roleRepository;
	
	@Autowired
	DTOUserConverter userConverter;
	@Autowired
	DTOUserRoleConverter roleConverter;
	
	
	@Override
	public UserDTO findOneById(Long id) {
		
		Optional <User> user = userRepository.findById(id);
		
		
		if (user.isPresent()) {
			
			return userConverter.convertToDTO(user.get());
		
		}
		else {
			
			return new UserDTO();
			
		}
		
	}

	@Override
	public List<UserDTO> findAll() {

		Optional< List<User> > list = Optional.of(userRepository.findAll());
		ArrayList< UserDTO > usersDTO = new ArrayList< UserDTO >();
		
		if ( list.isPresent() ) {
			
			for ( User user : list.get()) {
				
				usersDTO.add(userConverter.convertToDTO(user));
				
			}
			
			return usersDTO;
			
		}
		
		return Collections.emptyList();
		
	}

	@Override
	public UserDTO save(UserDTO userToSave) {
		
		userRepository.save(userConverter.convertFromDTO(userToSave));
		
		return userToSave;
	}

	@Override
	public UserDTO deleteById(Long id) {
		
		Optional<User> userToDelete = userRepository.findById(id);
		
		if( userToDelete.isPresent() ) {
		
			userRepository.deleteById(id);
			
			return userConverter.convertToDTO(userToDelete.get());
		
		}
		
		return new UserDTO();
		
		
	}

	@Override
	public UserDTO changeUser(Long id, UserDTO user) {
		
		Optional<User> userForChange = userRepository.findById(id);
		
		if( userForChange.isPresent() && user!=null) {
			
			Optional<UserRole> role = roleRepository.findById(user.getRole().getId());
			
			if(role.isPresent()) {
				
				userForChange.get().setCity(user.getCity());
				userForChange.get().setEmail(user.getEmail());
				userForChange.get().setName(user.getName());
				userForChange.get().setPassport(user.getPassport());
				userForChange.get().setRole(role.get());
				userForChange.get().setSurname(user.getSurname());
				userForChange.get().setTelephoneNumber(user.getTelephoneNumber());
				
				userRepository.save(userForChange.get());
				
				user.setId(userForChange.get().getId());
				
				return user;
				
			}
			
		}
		
		return null;
	}

}
