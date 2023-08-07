package com.codegym.casestudy_spring_module_4.service;

import com.codegym.casestudy_spring_module_4.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAllCustomerType();
}
