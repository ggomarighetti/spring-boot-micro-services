package com.ggomarighetti.microservices.employees.repository;

import com.ggomarighetti.microservices.employees.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {

    public EmployeeEntity findByFirstNameAndLastName(String firstName, String lastName);
}
