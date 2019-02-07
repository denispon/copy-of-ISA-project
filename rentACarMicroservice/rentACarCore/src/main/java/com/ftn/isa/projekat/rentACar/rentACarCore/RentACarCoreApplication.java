package com.ftn.isa.projekat.rentACar.rentACarCore;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication()
@EnableTransactionManagement
@EnableJpaRepositories
public class RentACarCoreApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(RentACarCoreApplication.class, args);
		
		
	}
}
