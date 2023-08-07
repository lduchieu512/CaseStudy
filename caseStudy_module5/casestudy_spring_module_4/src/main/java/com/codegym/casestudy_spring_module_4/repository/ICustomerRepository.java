package com.codegym.casestudy_spring_module_4.repository;

import com.codegym.casestudy_spring_module_4.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "select * from customer where customer_name like ? and customer_email like ? and customer_type_id like ?", nativeQuery = true)
    List<Customer> searchCustomer(String name, String email, String type);
}
