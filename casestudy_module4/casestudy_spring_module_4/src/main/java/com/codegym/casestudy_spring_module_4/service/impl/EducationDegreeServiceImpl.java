package com.codegym.casestudy_spring_module_4.service.impl;

import com.codegym.casestudy_spring_module_4.model.EducationDegree;
import com.codegym.casestudy_spring_module_4.repository.IEducationDegreeRepository;
import com.codegym.casestudy_spring_module_4.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {

    @Autowired
    IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return educationDegreeRepository.findAll();
    }
}
