package com.codegym.casestudy_spring_module_4.repository;

import com.codegym.casestudy_spring_module_4.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value = "select * from Employee where employee_name like ? and employee_email like ? and division_id like ?", nativeQuery = true)
    List<Employee> searchEmployee(String name, String email, String divisionId);
}
