package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.Position;
import com.codegym.casestudy_spring_module_4.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/positions")
public class PositionControllerAPI {

    @Autowired
    private IPositionService positionService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Position>> getAllPosition() {
        List<Position> positions = positionService.findAllPosition();
        if (positions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Position> findByIdPosition(@PathVariable Integer id) {
        Optional<Position> positionOptional = Optional.ofNullable(positionService.selectPosition(id));
        if (!positionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(positionOptional.get(), HttpStatus.OK);
    }
}
