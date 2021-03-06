package com.example.clip.controller;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.clip.model.dto.UserDTO;
import com.example.clip.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    
	@MockBean
	private UserService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	private static List<UserDTO> users;

	private static final String USERS_PAYMENTS_ENDPOINT = "/api/clip/usersWithPayments";
    
    @Test
    public void getUsersWithPaymentsTest() throws Exception {
    	
    	users = new ObjectMapper().readValue(Paths.get("src/test/resources/usersWithPayments.json").toFile(),
				new TypeReference<List<UserDTO>>() {
				});
    	doReturn(users).when(service).getUsersWithPayments();
		this.mockMvc.perform(get(USERS_PAYMENTS_ENDPOINT).accept(MediaType.APPLICATION_JSON))
		     .andDo(print()).andExpect(status().isOk());
    }
    
}
