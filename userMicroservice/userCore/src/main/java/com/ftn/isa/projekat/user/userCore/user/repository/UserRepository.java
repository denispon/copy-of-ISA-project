package com.ftn.isa.projekat.user.userCore.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ftn.isa.projekat.user.userApi.dto.UserDTO;
import com.ftn.isa.projekat.user.userCore.user.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	@Query(value="select * from user where id in (select * from friend_request where "
			+ "(invited_user = :id or source_user= :id) AND status='accepted') ",nativeQuery=true)
	Optional<List<UserDTO>> getAllFriends(Long id);

	Optional<User> findOneByEmail(String email);

}
