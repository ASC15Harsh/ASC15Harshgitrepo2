package com.demo.springbootIntergration.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;
    @Column(name="NAME", nullable=false)
    private String name;
    @Column(name="AGE", nullable=false)
    private int age;
    @Column(name="CITY", nullable=false)
    private String city;

    public employee() {
        // default no-arg constructor for JPA
    }
    public employee(int id, String name, int age, String city) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.city=city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }}