/*
 * Aaron Flores
 * Aplazo project
 * 26, Agosto 2021
 */

package com.api.SimpleInterest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.SimpleInterest.dto.SimpleInterestDTO;
import com.api.SimpleInterest.exceptions.ApiRequestException;
import com.api.SimpleInterest.models.RequestModel;
import com.api.SimpleInterest.services.IRequestService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/simpleinterest")
public class RequestController {

	@Autowired
	IRequestService requestService;
	
	
	@GetMapping()
	public String helloWorld(){
		return "Hello World";
	}

	@PostMapping()
	public List<SimpleInterestDTO> saveRequest(@Valid @RequestBody RequestModel requestModel){
		return this.requestService.saveRequest(requestModel);
	}
}
