package com.backend.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.employeemanagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
