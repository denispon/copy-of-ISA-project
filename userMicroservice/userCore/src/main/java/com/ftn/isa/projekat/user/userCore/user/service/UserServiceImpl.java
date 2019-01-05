package com.ftn.isa.projekat.user.userCore.user.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
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
	
	//Class for helping us with sending emails
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	//Class which loads information from application.properties file.
	
	@Autowired
	private Environment env;

	
	
	
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
		
		return new UserDTO();
	}

	@Override
	public List<UserDTO> getallFriends(Long id) {
		
		Optional<List<UserDTO>> friends = userRepository.getAllFriends(id);
		
		if(friends.isPresent()) {
			
			return friends.get();
			
		}
		
		
		return Collections.emptyList();
	}

	@Override
	@Async
	public UserDTO registerUser(UserDTO dto) {
		
		/*
		 * First we need to see if user with same email
		 * is already existing in database. If it does, we are giving back empty object with information on email with error
		 * info
		 * 
		 *  */
		Optional<User> foundUserByEmail = userRepository.findOneByEmail(dto.getEmail());

		if(foundUserByEmail.isPresent()) {
			UserDTO foundUser = new UserDTO();
			foundUser.setEmail("Email exits");
			
			return foundUser;
		}
		
		//if there is not user with same email, we are saving this one
		User savedUser= userRepository.save(userConverter.convertFromDTO(dto));
		
		//now we are sending activation link to the email address of registered user
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(dto.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Activation link for TRAVELwithRSK");
		mail.setText("Hello " + savedUser.getName() + ",\n\n Thank you for registration in our website. \n Please click on this link for activation of your account \n"
				+ " http://localhost:8096/api/user/user/activate/" + savedUser.getId() + "  ");
		javaMailSender.send(mail);
		
		dto.setId(savedUser.getId());
		
		return dto;
	}

	@Override
	public UserDTO activateUser(Long id) {
		
		Optional<User> foundUser = userRepository.findById(id);
		
		if(foundUser.isPresent()) {
			
			foundUser.get().setActive(true);
			
			userRepository.save(foundUser.get());
			
			return userConverter.convertToDTO(foundUser.get());
			
		}
		
		return new UserDTO();
		
	}

}
