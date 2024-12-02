package com.demo.springbootIntergration.repository;

import com.demo.springbootIntergration.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employee_repository extends JpaRepository<employee,Integer> {

}
