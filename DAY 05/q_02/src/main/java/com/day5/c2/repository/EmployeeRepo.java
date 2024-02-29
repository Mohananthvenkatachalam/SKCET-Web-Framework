package com.day5.c2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day5.c2.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
