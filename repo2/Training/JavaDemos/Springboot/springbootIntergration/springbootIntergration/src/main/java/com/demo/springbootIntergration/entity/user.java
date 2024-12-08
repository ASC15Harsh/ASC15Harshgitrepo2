package com.demo.springbootIntergration.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name="EMAIL", nullable=false)
    private String email;
    @Column(name="FIRST_NAME", nullable=false)
    private String first_name;
    @Column(name="LAST_NAME", nullable=false)
    private String last_name;

    public user() {
        // default no-arg constructor for JPA
    }
    public user(int id, String email,String first_name,String last_name) {
        super();
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}