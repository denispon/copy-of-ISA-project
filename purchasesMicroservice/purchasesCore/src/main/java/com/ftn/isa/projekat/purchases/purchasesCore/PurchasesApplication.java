package com.ftn.isa.projekat.purchases.purchasesCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication()
@EnableFeignClients(basePackages = {"client", "com.ftn.isa.projekat.rentACar.rentACarApi.client"})
public class PurchasesApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(PurchasesApplication.class, args);


	}

}
