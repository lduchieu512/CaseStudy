package com.codegym.casestudy_spring_module_4.service.impl;

import com.codegym.casestudy_spring_module_4.model.Position;
import com.codegym.casestudy_spring_module_4.repository.IPositionRepository;
import com.codegym.casestudy_spring_module_4.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    IPositionRepository positionRepository;

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAll();
    }
}
