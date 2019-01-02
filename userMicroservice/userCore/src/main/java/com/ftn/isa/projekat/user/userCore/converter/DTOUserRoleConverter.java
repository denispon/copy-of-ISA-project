package com.ftn.isa.projekat.user.userCore.converter;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.user.userApi.dto.UserDTO;
import com.ftn.isa.projekat.user.userApi.dto.UserRoleDTO;
import com.ftn.isa.projekat.user.userCore.user.model.User;
import com.ftn.isa.projekat.user.userCore.userRole.model.UserRole;

@Component
public class DTOUserRoleConverter {
	
	@Autowired
	DTOUserConverter userConverter;
	
	public UserRoleDTO convertToDTO (UserRole role) {
	
		UserRoleDTO dto = new UserRoleDTO();
		
		dto.setId(role.getId());
		dto.setRole(role.getRole());
		
		ArrayList<UserDTO> users = new ArrayList<UserDTO>();
		
		for(User user : role.getUser()) {
			
			users.add(userConverter.convertToDTO(user));
			
		}
		
		dto.setUsers(users);
		
		return dto;
		
	}
	
	public UserRole convertFromDTO (UserRoleDTO role) {
		
		UserRole bean = new UserRole();
		
		bean.setId(role.getId());
		bean.setRole(role.getRole());
		
		ArrayList<User> users = new ArrayList<User>();
		
		for(UserDTO user : role.getUsers()) {
			
			users.add(userConverter.convertFromDTO(user));
			
		}
		
		bean.setUser(users);
		
		return bean;
		
	}

}
