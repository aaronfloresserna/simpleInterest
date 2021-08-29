/*
 * Aaron Flores
 * Aplazo project
 * 26, Agosto 2021
 */

package com.api.SimpleInterest.services;

import org.springframework.stereotype.Service;

import com.api.SimpleInterest.dto.SimpleInterestDTO;
import com.api.SimpleInterest.models.RequestModel;
import com.api.SimpleInterest.models.ResponseModel;

import java.util.*;

@Service
public interface IRequestService {
	public List<SimpleInterestDTO> saveRequest(RequestModel requestModel);
}
