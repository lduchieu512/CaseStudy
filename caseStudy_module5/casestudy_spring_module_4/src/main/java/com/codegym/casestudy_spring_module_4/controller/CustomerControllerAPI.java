package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.Customer;
import com.codegym.casestudy_spring_module_4.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/customers")
public class CustomerControllerAPI {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> searchCustomer(@RequestParam(name = "nameSearch") String nameSearch,
                                                         @RequestParam(name = "emailSearch") String emailSearch,
                                                         @RequestParam(name = "typeSearch") String typeSearch) {
        return new ResponseEntity<>(customerService.searchCustomer(nameSearch, emailSearch, typeSearch), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Customer>> getAllCustomer() {
        List<Customer> customers = customerService.findAllList();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Customer> findByIdCustomer(@PathVariable String id) {
        Optional<Customer> customerOptional = Optional.ofNullable(customerService.selectCustomer(id));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.insertCustomer(customer), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        Optional<Customer> customerOptional = Optional.ofNullable(customerService.selectCustomer(id));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setCustomerId(customerOptional.get().getCustomerId());
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable String id) {
        Optional<Customer> customerOptional = Optional.ofNullable(customerService.selectCustomer(id));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }
}
