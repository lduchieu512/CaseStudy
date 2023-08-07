package com.codegym.casestudy_spring_module_4.repository;

import com.codegym.casestudy_spring_module_4.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from Employee where employee_name like ? and employee_email like ? and division_id like ?", nativeQuery = true)
    Page<Employee> searchEmployee(String name, String email, String divisionId, Pageable pageable);
}
