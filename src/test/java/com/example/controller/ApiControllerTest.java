package com.example.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.dto.BeanPojo;
import com.example.service.HelloService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ApiControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private ApiController apiController;
	
	@Mock
	HelloService helloService;
	
	@Before
	public void setup() throws Exception {
		mockMvc=MockMvcBuilders.standaloneSetup(apiController).build();
	}
	
	@Test
	public void hiTest() throws Exception {
		when(helloService.helloService()).thenReturn("Hi");
		mockMvc.perform(get("/hi")).andExpect(status().isOk()).andExpect(content().string("Hi"));
	}
	
	@Test
	public void dataTest() throws Exception {
		when(helloService.getData()).thenReturn(new BeanPojo("Dark","Ace"));
		mockMvc.perform(get("/data")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.first", Matchers.is("Dark")))
		.andExpect(jsonPath("$.second", Matchers.is("Ace")))
		.andExpect(jsonPath("$.*", Matchers.hasSize(2)));
	}
	
	@Test
	public void dataPostTest() throws Exception {
		String json = "{\"first\": \"Dark\",\"second\": \"Ace\"}";
		mockMvc.perform(post("/postData")
				.contentType(MediaType.APPLICATION_JSON)
                .content(json))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.first", Matchers.is("Dark")))
		.andExpect(jsonPath("$.second", Matchers.is("Ace")))
		.andExpect(jsonPath("$.*", Matchers.hasSize(2)));
		
	}

	
}
