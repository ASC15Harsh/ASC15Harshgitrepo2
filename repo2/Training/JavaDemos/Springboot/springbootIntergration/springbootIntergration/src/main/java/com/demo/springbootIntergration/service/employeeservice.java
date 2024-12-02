package com.demo.springbootIntergration.service;

import com.demo.springbootIntergration.entity.employee;
import com.demo.springbootIntergration.repository.employee_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class employeeservice {
    private final employee_repository employeeRepository;

    @Autowired
    public employeeservice(employee_repository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<employee> getAllEmployees() {
            return employeeRepository.findAll();

    }
}
