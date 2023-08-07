package com.codegym.casestudy_spring_module_4.service.impl;

import com.codegym.casestudy_spring_module_4.model.CustomerType;
import com.codegym.casestudy_spring_module_4.repository.ICustomerTypeRepository;
import com.codegym.casestudy_spring_module_4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {

    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }
}
