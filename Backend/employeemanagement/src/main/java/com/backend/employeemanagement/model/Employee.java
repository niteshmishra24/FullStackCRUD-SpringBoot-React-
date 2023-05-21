package com.backend.employeemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Employee(long id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
    public Employee() {
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + "]";
    }

    
}
