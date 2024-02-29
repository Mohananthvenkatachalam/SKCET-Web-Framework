package com.day_07_cw.q_02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day_07_cw.q_02.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
    List<Course> findByCourseName(String courseName);
}
