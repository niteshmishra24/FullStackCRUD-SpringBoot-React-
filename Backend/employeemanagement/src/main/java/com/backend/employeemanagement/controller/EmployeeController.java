package com.backend.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.employeemanagement.model.Employee;
import com.backend.employeemanagement.repository.EmployeeRepository;
import com.backend.employeemanagement.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/add-employee")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }

    @DeleteMapping("/delete-employee/{id}")
    public void deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/update-employee/{id}")
    public void updateEmployee(@RequestBody Employee employee,@PathVariable("id") long id){
        employeeService.updateEmployee(employee, id);
    }


    // @GetMapping("/employees/{id}")
    // public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
    //     Optional<Employee> employee = this.employeeService.getEmployeeById(id);

    //     return employee.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    // }
}
