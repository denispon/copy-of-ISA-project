package com.ftn.isa.projekat.purchases.purchasesCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication()
@EnableTransactionManagement
@EnableJpaRepositories
@EnableFeignClients(basePackages = {"client", "com.ftn.isa.projekat.avioCompany.avioCompanyApi.client", "com.ftn.isa.projekat.rentACar.rentACarApi.client", "com.ftn.isa.projekat.hotel.hotelApi.client" , "com.ftn.isa.projekat.user.userApi.client"})
public class PurchasesApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(PurchasesApplication.class, args);


	}

}
