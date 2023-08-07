package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.ServiceType;
import com.codegym.casestudy_spring_module_4.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/serviceType")
public class ServiceTypeControllerAPI {


    @Autowired
    private IServiceTypeService serviceTypeService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<ServiceType>> getAllRentType() {
        List<ServiceType> serviceTypes = serviceTypeService.findAllTypeService();
        if (serviceTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceTypes, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<ServiceType> findByIdRentType(@PathVariable Integer id) {
        Optional<ServiceType> serviceTypes = Optional.ofNullable(serviceTypeService.selectServiceType(id));
        if (!serviceTypes.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(serviceTypes.get(), HttpStatus.OK);
    }
}
