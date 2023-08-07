package com.codegym.casestudy_spring_module_4.service;

import com.codegym.casestudy_spring_module_4.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);

    List<Customer> findAllList();

    void insertCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(String id);

    Customer selectCustomer(String id);

    Page<Customer> searchCustomer(String nameSearch, String emailSearch, String typeSearch, Pageable pageable);
}
