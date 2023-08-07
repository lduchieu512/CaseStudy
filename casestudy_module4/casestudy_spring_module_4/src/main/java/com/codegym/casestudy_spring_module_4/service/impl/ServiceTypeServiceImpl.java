package com.codegym.casestudy_spring_module_4.service.impl;

import com.codegym.casestudy_spring_module_4.model.ServiceType;
import com.codegym.casestudy_spring_module_4.repository.IServiceTypeRepository;
import com.codegym.casestudy_spring_module_4.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {

    @Autowired
    IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAllTypeService() {
        return serviceTypeRepository.findAll();
    }
}
