package com.day_08_cw.q_03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.day_08_cw.q_03.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query("SELECT p FROM Student p WHERE p.marks > :marks")
    List<Student> findByNameGreater(@Param("marks") int marks);

    @Query("SELECT p FROM Student p WHERE p.marks < :marks")
    List<Student> findByNameLesser(@Param("marks") int marks);

}
