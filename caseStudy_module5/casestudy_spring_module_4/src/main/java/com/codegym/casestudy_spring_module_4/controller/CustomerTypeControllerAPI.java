package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.CustomerType;
import com.codegym.casestudy_spring_module_4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/customer-types")
public class CustomerTypeControllerAPI {

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<CustomerType>> getAllCustomerType() {
        List<CustomerType> customerTypes = customerTypeService.findAllCustomerType();
        if (customerTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerTypes, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<CustomerType> findByIdCustomerType(@PathVariable Integer id) {
        Optional<CustomerType> customerTypeOptional = Optional.ofNullable(customerTypeService.selectCustomerType(id));
        if (!customerTypeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerTypeOptional.get(), HttpStatus.OK);
    }
}
