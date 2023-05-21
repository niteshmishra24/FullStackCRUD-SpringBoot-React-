package com.backend.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.employeemanagement.model.Employee;
import com.backend.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(long id){
        return employeeRepository.findById(id);
    }

    public void createEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(long id){
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Employee employee,long id){
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);

        if(existingEmployeeOptional.isPresent()){
            Employee existingEmployee = existingEmployeeOptional.get(); 

            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setFirstname(employee.getFirstname());
            existingEmployee.setLastname(employee.getLastname());

            employeeRepository.save(existingEmployee);
        }
    }
}
