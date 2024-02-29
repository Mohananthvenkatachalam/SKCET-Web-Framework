package com.day5.c2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day5.c2.model.Employee;
import com.day5.c2.repository.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @SuppressWarnings("null")
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(int employeeId, Employee employee) {
        if (employeeRepo.existsById(employeeId)) {
            employee.setEmployeeId(employeeId);
            return employeeRepo.save(employee);
        } else {
            return null;
        }
    }

    public boolean deleteEmployee(int employeeId) {
        if (employeeRepo.existsById(employeeId)) {
            employeeRepo.deleteById(employeeId);
            return true;
        }
        return false;
    }
}
