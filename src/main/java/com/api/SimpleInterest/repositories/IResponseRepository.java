package com.api.SimpleInterest.repositories;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.SimpleInterest.models.RequestModel;
import com.api.SimpleInterest.models.ResponseModel;

@Repository
public interface IResponseRepository extends CrudRepository<ResponseModel, Long>{
    
    public List<ResponseModel> findAllByRequest(RequestModel request);
}
