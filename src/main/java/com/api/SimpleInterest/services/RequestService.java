/*
 * Aaron Flores
 * Aplazo project
 * 26, Agosto 2021
 */

package com.api.SimpleInterest.services;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SimpleInterest.dto.SimpleInterestDTO;
import com.api.SimpleInterest.models.RequestModel;
import com.api.SimpleInterest.models.ResponseModel;
import com.api.SimpleInterest.repositories.IResponseRepository;

@Service
public class RequestService implements IRequestService{
	
	@Autowired
	IResponseRepository responseRepository;
	
	@Override
	public List<SimpleInterestDTO> saveRequest(RequestModel requestModel) {
		
		//Compute the simple interest of any pay weekly
		List<ResponseModel> responses =  computeInterest(requestModel);

		//Save every weekly payment  
		for(ResponseModel res : responses){
			responseRepository.save(res);
		}
		
		return responseRepository
				.findAllByRequest(requestModel)
				.stream()
				.map(this::convertToSimpleInterestDTO)
						.collect(Collectors.toList());
		

		//return responseRepository.findAllByRequest(requestModel);
	}

	private List<ResponseModel> computeInterest(RequestModel requestModel){
		
		List<ResponseModel> res = new ArrayList<>();
		ResponseModel responseModel;

		//I = C * (I / 100) * T
		Double interest = requestModel.getAmount() * (requestModel.getRate() / 100) * requestModel.getTerms();
		
		//Double amountWeekly = (interest + amount) / terms; //  weekly
		//Double amountWeekly = (interest + amount) / (terms * 2); // biweekly
		Double amountWeekly = (interest + requestModel.getAmount()) / (requestModel.getTerms() * 4); // monthly
		//Double amountWeekly = (interest + amount) / terms * 52; // year

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		for(int paymentNumber = 1; paymentNumber <= requestModel.getTerms(); paymentNumber++){
			
			responseModel = new ResponseModel(paymentNumber, amountWeekly, simpleDateFormat.format(calendar.getTime()), requestModel);
			res.add(responseModel);
			calendar.add(Calendar.DATE, 7);
			
		}
		
		return res;
	}

	private SimpleInterestDTO convertToSimpleInterestDTO(ResponseModel responseModel) {
		SimpleInterestDTO simpleInterestDTO = new SimpleInterestDTO(
			responseModel.getPayment_number(), 
			responseModel.getAmount(), 
			responseModel.getPayment_date());

		return simpleInterestDTO;
	}
}
