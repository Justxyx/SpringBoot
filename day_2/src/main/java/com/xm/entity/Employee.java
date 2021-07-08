package com.xm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;



public class Employee {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGerder() {
        return gerder;
    }

    public void setGerder(Integer gerder) {
        this.gerder = gerder;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String lastName;
    private String email;
    private Integer gerder;

    private Department department;
    private Date date;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Integer gerder, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;

        this.gerder = gerder;
        this.department = department;
        this.date = new Date();
    }
}
