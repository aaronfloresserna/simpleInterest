/*
 * Aaron Flores
 * Aplazo project
 * 26, Agosto 2021
 */

package com.api.SimpleInterest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.SimpleInterest.models.RequestModel;

@Repository
public interface IRequestRepository extends CrudRepository<RequestModel, Long>{
    
}
