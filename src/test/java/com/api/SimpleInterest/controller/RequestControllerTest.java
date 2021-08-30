package com.api.SimpleInterest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

//import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.ZoneId;

import com.api.SimpleInterest.controllers.RequestController;
import com.api.SimpleInterest.dto.SimpleInterestDTO;
import com.api.SimpleInterest.models.RequestModel;
import com.api.SimpleInterest.models.ResponseModel;
import com.api.SimpleInterest.repositories.IResponseRepository;
import com.api.SimpleInterest.services.IRequestService;
import com.api.SimpleInterest.services.RequestService;

@WebMvcTest(RequestController.class)
public class RequestControllerTest {
    
    @Autowired 
    private MockMvc mockMvc;

    @MockBean
    IRequestService requestService;

    @Autowired
    private ObjectMapper mapper;

    private List<SimpleInterestDTO> responses;

    private RequestModel request;

    private String URL = "/simpleinterest";

    private LocalDate date = LocalDate.now(ZoneId.of("America/Mexico_City"));
    
    @InjectMocks
	RequestService reqService;
	
	@Mock
	IResponseRepository resRepository;
	
	
    
    @BeforeEach
    void setUp(){
    	
        responses = List.of(
			new SimpleInterestDTO(1, 2647.25, date),
			new SimpleInterestDTO(2, 2647.25, date.plusWeeks(1)),
			new SimpleInterestDTO(3, 2647.25, date.plusWeeks(2)),
			new SimpleInterestDTO(4, 2647.25, date.plusWeeks(3))
			);

        request = new RequestModel(10000.0, 1, 5.89);
    }

    @Test
    void createRequestTest() throws Exception {

        Mockito.when(requestService.saveRequest(request)).thenReturn(responses);
        

        MvcResult result = mockMvc.perform(
        			MockMvcRequestBuilders
        			.post(URL)
                	.contentType(MediaType.APPLICATION_JSON)
                	.content(mapper.writeValueAsString(request))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        
        Assertions.assertThat(result).isNotNull();
    }
    
    @Test
	public void saveResponseTest() {
		
		RequestModel req = new RequestModel(10000.0, 1, 3.87);
		
		ResponseModel res = new ResponseModel(1, 2596.75, LocalDate.now(), req);
		
		Mockito.when(resRepository.save(res)).thenReturn(res);
		
		List<SimpleInterestDTO> resDto = reqService.saveRequest(req);
		
		//assertNotNull(resDto);
	}
}
