package com.day_04_cw.q_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day_04_cw.q_02.model.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {

}
