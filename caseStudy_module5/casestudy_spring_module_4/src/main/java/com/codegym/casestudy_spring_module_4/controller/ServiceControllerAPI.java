package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.Customer;
import com.codegym.casestudy_spring_module_4.model.Service;
import com.codegym.casestudy_spring_module_4.service.IRentTypeService;
import com.codegym.casestudy_spring_module_4.service.IServiceService;
import com.codegym.casestudy_spring_module_4.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/facilities")
public class ServiceControllerAPI {


    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Service>> getAllService() {
        List<Service> service = serviceService.findAllList();
        if (service.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Service> findByIdService(@PathVariable String id) {
        Optional<Service> service = Optional.ofNullable(serviceService.selectService(id));
        if (!service.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.get(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Service> saveCustomer(@RequestBody Service service) {
        return new ResponseEntity<>(serviceService.insertService(service), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Service> deleteCustomer(@PathVariable String id) {
        Optional<Service> service = Optional.ofNullable(serviceService.selectService(id));
        if (!service.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        serviceService.deleteService(id);
        return new ResponseEntity<>(service.get(), HttpStatus.NO_CONTENT);
    }


}
