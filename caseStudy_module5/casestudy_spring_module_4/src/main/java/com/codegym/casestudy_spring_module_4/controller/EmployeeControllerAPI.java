package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.Employee;
import com.codegym.casestudy_spring_module_4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/employees")
public class EmployeeControllerAPI {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<Employee>> searchEmployee(@RequestParam(name = "nameSearch") String nameSearch,
                                                         @RequestParam(name = "emailSearch") String emailSearch,
                                                         @RequestParam(name = "divisionSearch") String divisionSearch) {
        return new ResponseEntity<>(employeeService.searchEmployee(nameSearch, emailSearch, divisionSearch), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.findAllList();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Employee> findByIdEmployee(@PathVariable String id) {
        Optional<Employee> employeeOptional = Optional.ofNullable(employeeService.selectEmployee(id));
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.insertEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable String id) {
        Optional<Employee> employeeOptional = Optional.ofNullable(employeeService.selectEmployee(id));
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.NO_CONTENT);
    }
}
