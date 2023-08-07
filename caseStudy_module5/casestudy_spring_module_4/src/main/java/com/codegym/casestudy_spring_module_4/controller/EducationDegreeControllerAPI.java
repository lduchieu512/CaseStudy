package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.EducationDegree;
import com.codegym.casestudy_spring_module_4.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/education-degrees")
public class EducationDegreeControllerAPI {

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<EducationDegree>> getAllEducationDegree() {
        List<EducationDegree> educationDegrees = educationDegreeService.findAllEducationDegree();
        if (educationDegrees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(educationDegrees, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<EducationDegree> findByIdEducationDegree(@PathVariable Integer id) {
        Optional<EducationDegree> educationDegreeOptional = Optional.ofNullable(educationDegreeService.selectEducationDegree(id));
        if (!educationDegreeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(educationDegreeOptional.get(), HttpStatus.OK);
    }
}
