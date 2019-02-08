package com.ftn.isa.projekat.rentACar.rentACarCore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;
import com.ftn.isa.projekat.rentACar.rentACarCore.carType.model.CarType;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarDiscountsControllerTest {

	private static final String URL_PREFIX = "/api/rentacar/carDiscounts";

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testGetAll() throws Exception{
		
		mockMvc.perform(get(URL_PREFIX + "/all")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetOneById() throws Exception{
		
		mockMvc.perform(get(URL_PREFIX + "/4")).andExpect(status().isOk());
			
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSave() throws Exception{
		
		
		
		String json = "{ \"id\": -1, \"dateFrom\": \"2019-02-10T00:00:01\", \"dateTo\": \"2020-02-10T00:09:00\", \"carDiscountPrecentage\": 30, \"carId\": {\"id\": 2, \"rentPrice\": 23, \"carType\": { \"id\": 2, \"numberOfSeats\": \"\", \"modelYear\": \"\", \"model\": \"\", \"brand\": \"\", \"carType\": \"\" }, \"rentService\": { \"id\": 2, \"name\": \"\", \"adress\": \"\", \"description\": \"\" }, \"branchOffice\": { \"id\": 2, \"name\": \"\", \"adress\": \"\", \"city\": \"\", \"rentServiceDTO\": { \"id\": 2, \"adress\": \"\", \"name\": \"\", \"description\": \"\" } } } }";
		
		
		mockMvc.perform(post(URL_PREFIX + '/').header("Role", "CARADMIN").contentType(contentType).content(json)).andExpect(status().isCreated());
			
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteById() throws Exception{
		
		this.mockMvc.perform(delete(URL_PREFIX + "/4").header("Role", "CARADMIN")).andExpect(status().isOk());
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdate() throws Exception{
		

		String json = "{ \"id\": 4, \"dateFrom\": \"2019-02-10T00:00:01\", \"dateTo\": \"2020-02-10T00:09:00\", \"carDiscountPrecentage\": 30, \"carId\": {\"id\": 2, \"rentPrice\": 23, \"carType\": { \"id\": 2, \"numberOfSeats\": \"\", \"modelYear\": \"\", \"model\": \"\", \"brand\": \"\", \"carType\": \"\" }, \"rentService\": { \"id\": 2, \"name\": \"\", \"adress\": \"\", \"description\": \"\" }, \"branchOffice\": { \"id\": 2, \"name\": \"\", \"adress\": \"\", \"city\": \"\", \"rentServiceDTO\": { \"id\": 2, \"adress\": \"\", \"name\": \"\", \"description\": \"\" } } } }";
		this.mockMvc.perform(put(URL_PREFIX + "/4").header("Role", "CARADMIN").contentType(contentType).content(json)).andExpect(status().isBadRequest());

		
	} 
}