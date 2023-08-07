package com.codegym.casestudy_spring_module_4.service.impl;

import com.codegym.casestudy_spring_module_4.model.ContractDetail;
import com.codegym.casestudy_spring_module_4.repository.IContractDetailRepository;
import com.codegym.casestudy_spring_module_4.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {

    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAllContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void insert(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
