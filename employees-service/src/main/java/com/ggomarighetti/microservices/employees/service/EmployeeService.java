package com.ggomarighetti.microservices.employees.service;

import com.ggomarighetti.microservices.employees.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeEntity> findAll();

    public EmployeeEntity findById(String id);
}
