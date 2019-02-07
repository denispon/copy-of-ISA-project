package com.ftn.isa.projekat.user.userCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication()
@EnableTransactionManagement
@EnableJpaRepositories
//Enabling async because of later using email services
@EnableAsync
public class UserApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(UserApplication.class, args);
		
		
	}

}
