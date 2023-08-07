package com.codegym.casestudy_spring_module_4.repository;

import com.codegym.casestudy_spring_module_4.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Service, String> {
    @Query(value = "select * from service where service_name like ? and rent_type_id like ? and service_type_id like ?", nativeQuery = true)
    Page<Service> searchService(String name, String rentType, String type, Pageable pageable);
}
