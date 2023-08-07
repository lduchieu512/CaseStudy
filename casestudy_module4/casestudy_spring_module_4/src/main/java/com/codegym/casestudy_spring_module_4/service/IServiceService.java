package com.codegym.casestudy_spring_module_4.service;

import com.codegym.casestudy_spring_module_4.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    Page<Service> findAllService(Pageable pageable);

    List<Service> findAllList();

    void insertService(Service service);

    void updateService(Service service);

    void deleteService(String id);

    Service selectService(String id);
}
