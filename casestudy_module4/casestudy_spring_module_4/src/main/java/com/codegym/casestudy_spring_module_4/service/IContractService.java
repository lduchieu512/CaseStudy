package com.codegym.casestudy_spring_module_4.service;

import com.codegym.casestudy_spring_module_4.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> findAllContract(Pageable pageable);

    void insert(Contract contract);
}
