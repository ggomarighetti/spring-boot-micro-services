package com.ggomarighetti.microservices.employees.controller;

import com.ggomarighetti.microservices.employees.entity.EmployeeEntity;
import com.ggomarighetti.microservices.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<EmployeeEntity> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeEntity findById(@PathVariable String id) {
        return employeeService.findById(id);
    }
}
