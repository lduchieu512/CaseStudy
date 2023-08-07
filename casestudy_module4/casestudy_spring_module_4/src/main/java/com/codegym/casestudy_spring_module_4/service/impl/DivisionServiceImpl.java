package com.codegym.casestudy_spring_module_4.service.impl;

import com.codegym.casestudy_spring_module_4.model.Division;
import com.codegym.casestudy_spring_module_4.repository.IDivisionRepository;
import com.codegym.casestudy_spring_module_4.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {

    @Autowired
    IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }
}
