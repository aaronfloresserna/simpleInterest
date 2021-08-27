/*
 * Aaron Flores
 * Aplazo project
 * 26, Agosto 2021
 */

package com.api.SimpleInterest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.SimpleInterest.models.RequestModel;

public interface IRequestRepository extends CrudRepository<RequestModel, Long>{
    
}
