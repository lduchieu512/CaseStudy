package com.codegym.casestudy_spring_module_4.service.impl;

import com.codegym.casestudy_spring_module_4.model.AttachService;
import com.codegym.casestudy_spring_module_4.repository.IAttachServiceRepository;
import com.codegym.casestudy_spring_module_4.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements IAttachServiceService {

    @Autowired
    IAttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAllAttachService() {
        return attachServiceRepository.findAll();
    }
}
