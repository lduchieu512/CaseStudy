package com.codegym.casestudy_spring_module_4.service;

import com.codegym.casestudy_spring_module_4.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAllContractDetail();

    void insert(ContractDetail contractDetail);
}
