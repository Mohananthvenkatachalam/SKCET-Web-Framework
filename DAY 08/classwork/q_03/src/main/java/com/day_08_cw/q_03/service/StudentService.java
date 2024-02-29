package com.day_08_cw.q_03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_08_cw.q_03.model.Student;
import com.day_08_cw.q_03.repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    public StudentRepo personRepo;

    public Student postAPerson(Student person) {
        return personRepo.save(person);
    }

    public List<Student> getAllPerson() {
        return personRepo.findAll();
    }

    public List<Student> getByStart(int marks) {
        return personRepo.findByNameGreater(marks);
    }

    public List<Student> getByEnd(int marks) {
        return personRepo.findByNameLesser(marks);
    }
}
