/*
 * Aaron Flores
 * Aplazo project
 * 26, Agosto 2021
 */

package com.api.SimpleInterest.services;

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SimpleInterest.dto.SimpleInterestDTO;
import com.api.SimpleInterest.exceptions.ApiRequestException;
import com.api.SimpleInterest.models.RequestModel;
import com.api.SimpleInterest.models.ResponseModel;
import com.api.SimpleInterest.repositories.IResponseRepository;

@Service
public class RequestService implements IRequestService{
	
	@Autowired
	IResponseRepository responseRepository;

	private LocalDate date = LocalDate.now(ZoneId.of("America/Mexico_City"));
	
	@Override
	public List<SimpleInterestDTO> saveRequest(RequestModel requestModel) {
		
		//Validation
		validate(requestModel);

		//Compute the simple interest of any pay weekly
		computeInterest(requestModel);
		
		return responseRepository
				.findAllByRequest(requestModel)
				.stream()
				.map(this::convertToSimpleInterestDTO)
				.collect(Collectors.toList());
	}

	//Validation of the request 
	private void validate(RequestModel requestModel) {
		if(requestModel.getAmount() == null ) throw new ApiRequestException("amount property required");
		if(requestModel.getAmount() <= 0 ) throw new ApiRequestException("amount has to be grater than 0 or not null");

		if(requestModel.getRate() == null ) throw new ApiRequestException("rate property required");
		if(requestModel.getRate() <= 0 ) throw new ApiRequestException("rate has to be grater than 0 or not null");

		if(requestModel.getTerms() == null ) throw new ApiRequestException("terms property required");
		if(requestModel.getTerms() <= 0 ) throw new ApiRequestException("terms has to be grater than 0 or not null");
	}

	//Method to compute simple interest 
	private void computeInterest(RequestModel requestModel){

		Double interest = requestModel.getAmount() * (requestModel.getRate() / 100) * requestModel.getTerms();
		
		//Assuming that the input terms and rate are in monttly
		Double amountWeekly = (interest + requestModel.getAmount()) / (requestModel.getTerms() * 4); // monthly

		int countWeek = 0;

		for(int paymentNumber = 1; paymentNumber <= requestModel.getTerms() * 4; paymentNumber++){
			
			responseRepository.save(
				new ResponseModel(
					paymentNumber,
					amountWeekly, 
					date.plusWeeks(countWeek++),
					requestModel
				)
			);
		}
	}

	//Convert the responseModel to simpleInterestDTO
	private SimpleInterestDTO convertToSimpleInterestDTO(ResponseModel responseModel) {
		
		SimpleInterestDTO simpleInterestDTO = 
			new SimpleInterestDTO(
				responseModel.getPayment_number(), 
				responseModel.getAmount(), 
				responseModel.getPayment_date()
			);

		return simpleInterestDTO;
	}
}
