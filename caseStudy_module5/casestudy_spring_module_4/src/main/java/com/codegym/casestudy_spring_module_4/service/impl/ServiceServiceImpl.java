package com.codegym.casestudy_spring_module_4.service.impl;

import com.codegym.casestudy_spring_module_4.model.Service;
import com.codegym.casestudy_spring_module_4.repository.IServiceRepository;
import com.codegym.casestudy_spring_module_4.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {

    @Autowired
    IServiceRepository serviceRepository;

    @Override
    public Page<Service> findAllService(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<Service> findAllList() {
        return serviceRepository.findAll();
    }

    @Override
    public Service insertService(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public void updateService(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteService(String id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Service selectService(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Service> searchService(String nameSearch, String rentTypeSearch, String typeSearch, Pageable pageable) {
        return serviceRepository.searchService("%" + nameSearch + "%", "%" + rentTypeSearch + "%", "%" + typeSearch + "%", pageable);
    }
}
