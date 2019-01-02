package com.ftn.isa.projekat.user.userCore.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.isa.projekat.user.userCore.user.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
