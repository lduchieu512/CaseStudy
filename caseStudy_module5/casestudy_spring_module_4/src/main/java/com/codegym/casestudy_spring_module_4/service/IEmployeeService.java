package com.codegym.casestudy_spring_module_4.service;

import com.codegym.casestudy_spring_module_4.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAllEmployee(Pageable pageable);

    List<Employee> findAllList();

    Employee insertEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(String id);

    Employee selectEmployee(String id);

    List<Employee> searchEmployee(String nameSearch, String emailSearch, String divisionSearch);
}
