package com.day_07_cw.q_02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_07_cw.q_02.model.Course;
import com.day_07_cw.q_02.repository.CourseRepo;

@Service
public class CourseService {

    @Autowired
    public CourseRepo personRepo;

    public Course postAPerson(Course person) {
        return personRepo.save(person);
    }

    public List<Course> getAllPerson() {
        return personRepo.findAll();
    }

    public List<Course> getByAgePerson(String courseName) {
        return personRepo.findByCourseName(courseName);
    }
}
