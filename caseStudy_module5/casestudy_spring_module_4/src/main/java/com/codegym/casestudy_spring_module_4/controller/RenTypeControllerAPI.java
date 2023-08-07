package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.CustomerType;
import com.codegym.casestudy_spring_module_4.model.RentType;
import com.codegym.casestudy_spring_module_4.service.ICustomerTypeService;
import com.codegym.casestudy_spring_module_4.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/rentType")
public class RenTypeControllerAPI {

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<RentType>> getAllRentType() {
        List<RentType> rentTypes = rentTypeService.findAllRentType();
        if (rentTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rentTypes, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<RentType> findByIdRentType(@PathVariable Integer id) {
        Optional<RentType> rentType = Optional.ofNullable(rentTypeService.selectRentType(id));
        if (!rentType.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rentType.get(), HttpStatus.OK);
    }
}
