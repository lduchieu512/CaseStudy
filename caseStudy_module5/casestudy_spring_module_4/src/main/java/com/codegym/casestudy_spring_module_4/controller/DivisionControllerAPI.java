package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.Division;
import com.codegym.casestudy_spring_module_4.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/divisions")
public class DivisionControllerAPI {

    @Autowired
    private IDivisionService divisionService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Division>> getAllEducationDegree() {
        List<Division> divisions = divisionService.findAllDivision();
        if (divisions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(divisions, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Division> findByIdDivision(@PathVariable Integer id) {
        Optional<Division> divisionOptional = Optional.ofNullable(divisionService.selectDivision(id));
        if (!divisionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(divisionOptional.get(), HttpStatus.OK);
    }
}
