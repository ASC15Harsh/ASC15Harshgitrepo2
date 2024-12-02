package com.demo.springbootIntergration.controller;


import com.demo.springbootIntergration.entity.employee;
import com.demo.springbootIntergration.service.employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class employeecontroller {

    private final employeeservice employeeService;

    @Autowired
    public employeecontroller(employeeservice employeeService) {
        this.employeeService = employeeService;
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<employee>> getAllEmployees() {
            List<employee> employees = employeeService.getAllEmployees();
            return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
