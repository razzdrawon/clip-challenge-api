package com.example.clip.controller;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.clip.model.dto.ReportPerUserDTO;
import com.example.clip.service.TransactionService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {
    
	@MockBean
	private TransactionService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	private static final Long userId = (long) 1;
	private static ReportPerUserDTO report;

	private static final String REPORT_ENDPOINT = "/api/clip/payments/report/" + userId;
    
    @Test
    public void reportPerUserTest() throws Exception {
    	
    	report = new ObjectMapper().readValue(Paths.get("src/test/resources/reportPerUser.json").toFile(),
				new TypeReference<ReportPerUserDTO>() {
				});
    	doReturn(report).when(service).createReportPerUser(userId);
		this.mockMvc.perform(get(REPORT_ENDPOINT).accept(MediaType.APPLICATION_JSON))
		     .andDo(print()).andExpect(status().isOk());
    }
    
}
