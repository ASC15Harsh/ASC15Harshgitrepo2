package com.demo.springbootIntergration.service;

import com.demo.springbootIntergration.entity.user;
import com.demo.springbootIntergration.repository.user_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userservice {
    private final user_repository userRepository;

    @Autowired
    public userservice(user_repository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<user> getAlluser() {
            return userRepository.findAll();
    }
    public user getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public user saveEmployee(user employee) {
        return userRepository.save(employee);
    }
    public void deleteEmployee(int id) {
        userRepository.deleteById(id);
    }

}
