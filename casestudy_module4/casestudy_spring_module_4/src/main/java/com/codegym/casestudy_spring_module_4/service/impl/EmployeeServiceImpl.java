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
    public void insertEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee selectEmployee(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> searchEmployee(String nameSearch, String emailSearch, String divisionSearch, Pageable pageable) {
        return employeeRepository.searchEmployee("%" + nameSearch + "%", "%" + emailSearch + "%", "%" + divisionSearch + "%", pageable);
    }
}
