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

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentACarServiceControllerTest {

	private static final String URL_PREFIX = "/api/rentacar/rentACarService";

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
		
		mockMvc.perform(get(URL_PREFIX + "/2")).andExpect(status().isOk());
			
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSave() throws Exception{
		
			
		String json = "{ \"id\": -1, \"name\": \"\", \"adress\": \"\", \"city\": \"\" }";
		
		
		mockMvc.perform(post(URL_PREFIX + '/').header("Role", "ADMIN").contentType(contentType).content(json)).andExpect(status().isCreated());
			
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteById() throws Exception{
		
		this.mockMvc.perform(delete(URL_PREFIX + "/2").header("Role", "ADMIN")).andExpect(status().isOk());
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdate() throws Exception{
		
		String json = "{ \"id\": 2, \"name\": \"\", \"adress\": \"\", \"city\": \"\" }";

		this.mockMvc.perform(put(URL_PREFIX + "/2").header("Role", "ADMIN").contentType(contentType).content(json)).andExpect(status().isOk());

		
	}
}