package com.demo.springbootIntergration.repository;

import com.demo.springbootIntergration.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface user_repository extends JpaRepository<user,Integer> {

}
