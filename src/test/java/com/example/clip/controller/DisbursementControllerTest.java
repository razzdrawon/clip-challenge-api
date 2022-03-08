package com.example.clip.controller;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.example.clip.model.dto.UserDisbursementDTO;
import com.example.clip.service.DisbursementService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(DisbursementController.class)
public class DisbursementControllerTest {
    
	@MockBean
	private DisbursementService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	private static List<UserDisbursementDTO> usersDisbursement;

	private static final String DISBURSEMENTS_ENDPOINT = "/api/clip/disbursements";
    
    
    @Test
    public void processDisbursementTest() throws Exception {
    	
    	usersDisbursement = new ObjectMapper().readValue(Paths.get("src/test/resources/disbursementsProcess.json").toFile(),
				new TypeReference<List<UserDisbursementDTO>>() {
				});
    	System.out.println(usersDisbursement);
    	doReturn(usersDisbursement).when(service).processDisbursements();
		this.mockMvc.perform(post(DISBURSEMENTS_ENDPOINT).accept(MediaType.APPLICATION_JSON))
		     .andDo(print()).andExpect(status().isCreated());
    }
    
}
