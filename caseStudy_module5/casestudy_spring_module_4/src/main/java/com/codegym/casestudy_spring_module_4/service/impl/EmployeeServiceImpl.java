package com.codegym.casestudy_spring_module_4.service.impl;

import com.codegym.casestudy_spring_module_4.model.Employee;
import com.codegym.casestudy_spring_module_4.repository.IEmployeeRepository;
import com.codegym.casestudy_spring_module_4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAllList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee selectEmployee(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> searchEmployee(String nameSearch, String emailSearch, String divisionSearch) {
        return employeeRepository.searchEmployee("%" + nameSearch + "%", "%" + emailSearch + "%", "%" + divisionSearch + "%");
    }
}
