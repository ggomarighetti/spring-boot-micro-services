package com.ggomarighetti.microservices.employees.seeder;

import com.ggomarighetti.microservices.employees.entity.EmployeeEntity;
import com.ggomarighetti.microservices.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EmployeeSeeder implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySeeded = false;

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final String[] FIRST_NAMES = {
            "Santiago",
            "Matero",
            "Juan",
            "Nicolas",
            "Pedro",
            "Tomas",
            "Thiago",
            "Santino"
    };

    private static final String[] LAST_NAMES = {
            "Gonzalez",
            "Rodriguez",
            "Gomez",
            "Fernandez",
            "Lopez",
            "Martinez",
            "Diaz",
            "Perez"
    };

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySeeded)
            return;

        for (String firstName : FIRST_NAMES) {
            for (String lastName : LAST_NAMES) {
                CreateEmployeeIfNotFound(firstName, lastName);
            }
        }
    }

    void CreateEmployeeIfNotFound(String firstName, String lastName) {

        EmployeeEntity employeeEntity = employeeRepository.findByFirstNameAndLastName(firstName, lastName);

        if (employeeEntity == null) {

            employeeEntity = EmployeeEntity.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .nationality("Argentino")
                    .identityNumber(String.valueOf(new Random().nextInt(40000000)))
                    .build();

            employeeRepository.save(employeeEntity);
        }

        return;
    }
}
