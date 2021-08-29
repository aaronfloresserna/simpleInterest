/*
 * Aaron Flores
 * Aplazo project
 * 26, Agosto 2021
 */

package com.api.SimpleInterest.services;


import java.util.*;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;

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
	
	@Override
	public List<SimpleInterestDTO> saveRequest(RequestModel requestModel) {
		
		//Validation
		validate(requestModel);

		//Compute the simple interest of any pay weekly
		List<ResponseModel> responses =  computeInterest(requestModel);

		saveSimpleInteres(responses);
		
		return responseRepository
				.findAllByRequest(requestModel)
				.stream()
				.map(this::convertToSimpleInterestDTO)
				.collect(Collectors.toList());
	}

	private void validate(RequestModel requestModel) {
		if(requestModel.getAmount() <= 0) throw new ApiRequestException("amount should be grater than 0");
		if(requestModel.getRate() <= 0) throw new ApiRequestException("rate should be grater than 0");
		if(requestModel.getTerms() <= 0) throw new ApiRequestException("terms should be grater than 0");
	}

	//Method to compute simple interest 
	private List<ResponseModel> computeInterest(RequestModel requestModel){
		
		List<ResponseModel> res = new ArrayList<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		Double interest = requestModel.getAmount() * (requestModel.getRate() / 100) * requestModel.getTerms();
		
		//Assuming that the input terms and rate are in monttly
		Double amountWeekly = (interest + requestModel.getAmount()) / (requestModel.getTerms() * 4); // monthly

		for(int paymentNumber = 1; paymentNumber <= requestModel.getTerms(); paymentNumber++){
			
			res.add(new ResponseModel(
				paymentNumber,
				 amountWeekly, 
				 simpleDateFormat.format(calendar.getTime()), requestModel));
			
			//Add 7 days in each payment week
			calendar.add(Calendar.DATE, 7);
			
		}
		
		return res;
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

	//Save every weekly payment 
	private void saveSimpleInteres(List<ResponseModel> responses) { 
		for(ResponseModel res : responses){
			responseRepository.save(res);
		}
	}
}
