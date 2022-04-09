package com.ggomarighetti.microservices.employees.service;

import com.ggomarighetti.microservices.employees.entity.EmployeeEntity;
import com.ggomarighetti.microservices.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public EmployeeEntity findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
