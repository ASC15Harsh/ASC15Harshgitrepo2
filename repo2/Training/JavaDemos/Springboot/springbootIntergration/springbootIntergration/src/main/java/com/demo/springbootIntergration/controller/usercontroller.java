package com.demo.springbootIntergration.controller;


import com.demo.springbootIntergration.entity.user;
import com.demo.springbootIntergration.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class usercontroller {

    private final userservice userService;

    @Autowired
    public usercontroller(userservice userService)
    {
        this.userService = userService;
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<user>> getAllEmployees() {
            List<user> employees = userService.getAlluser();
            return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<user> addEmployee(@RequestBody user newEmployee) {
            user createdEmployee = userService.saveEmployee(newEmployee);
            return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<user> updateEmployee(@PathVariable int id, @RequestBody user employee) {
        user existingEmployee = userService.getUserById(id);
        if (existingEmployee != null) {
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setFirst_name(employee.getFirst_name());
            existingEmployee.setLast_name(employee.getLast_name());
            userService.saveEmployee(existingEmployee);
            return new ResponseEntity<>(existingEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        user existingEmployee = userService.getUserById(id);
        if (existingEmployee != null) {
            userService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
