package com.codegym.casestudy_spring_module_4.service.impl;

import com.codegym.casestudy_spring_module_4.model.RentType;
import com.codegym.casestudy_spring_module_4.repository.IRentTypeRepository;
import com.codegym.casestudy_spring_module_4.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements IRentTypeService {

    @Autowired
    IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }
}
