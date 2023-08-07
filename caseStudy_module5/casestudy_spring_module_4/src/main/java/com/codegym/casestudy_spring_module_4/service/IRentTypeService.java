package com.codegym.casestudy_spring_module_4.service;

import com.codegym.casestudy_spring_module_4.model.CustomerType;
import com.codegym.casestudy_spring_module_4.model.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAllRentType();
    RentType selectRentType(Integer id);

}
